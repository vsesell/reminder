package com.serge.reminder.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemindRepositoryCustomImpl implements RemindRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Tuple> findFilterDateTime(Date date, Time time, Pageable pageable) {
        Map<String, Object> parametrMap = new HashMap<>();
        List<String> whereClause = new ArrayList<>();



        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select r.id as id," +
                "r.title as title," +
                "r.description as description," +
                "cast(r.remind as date) as date," +
                "cast(r.remind as time) as time from Remind r");

        if (date != null) {
            whereClause.add(" cast(r.remind as date) =:date");
            parametrMap.put("date", date);
        }
        if (time != null) {
            whereClause.add(" cast(r.remind as time) =:time");
            parametrMap.put("time", time);
        }

        queryBuilder.append(" where ").append(String.join(" and ", whereClause));

        // Запрос для получения данных
        TypedQuery<Tuple> query = em.createQuery(queryBuilder.toString(), Tuple.class);
        parametrMap.forEach(query::setParameter);
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        List<Tuple> resultList = query.getResultList();



        // Запрос для подсчета общего количества записей
        StringBuilder countQueryBuilder = new StringBuilder();
        countQueryBuilder.append("select count(r) from Remind r");
        if (time != null || date != null) {
            List<String> countWhereClause = new ArrayList<>();
            if (date != null) {
                countWhereClause.add(" cast(r.remind as date) =:date");
            }
            if (time != null) {
                countWhereClause.add(" cast(r.remind as time) =:time");
            }
            countQueryBuilder.append(" where ").append(String.join(" and ", countWhereClause));
        }
        TypedQuery<Long> countQuery = em.createQuery(countQueryBuilder.toString(), Long.class);
        if (date != null) {
            countQuery.setParameter("date", date);
        }
        if (time != null) {
            countQuery.setParameter("time", time);
        }
        Long total = countQuery.getSingleResult();

        // Возвращаем Page
        return new PageImpl<>(resultList, pageable, total);
    }
}
