package com.example.expgenweb.service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExpenseService {
    private final CqlSession session;

    public ExpenseService(CqlSession session) {
        this.session = session;
    }

    public Double getTotalAmountForEmployee(Integer empno) {
        String query = "SELECT payment FROM expenses_ks.expenses WHERE user_id = ?";
        ResultSet rs = session.execute(query, empno);

        double totalAmount = 0.0;
        for (Row row : rs) {
            totalAmount += row.getDouble("payment");
        }
        return totalAmount;
    }

    public Map<Integer, Double> getAllEmployeesTotalAmount() {
        String query = "SELECT user_id, payment FROM expenses_ks.expenses";
        ResultSet rs = session.execute(query);

        Map<Integer, Double> totalAmounts = new HashMap<>();
        for (Row row : rs) {
            int userId = row.getInt("user_id");
            double payment = row.getDouble("payment");
            totalAmounts.merge(userId, payment, Double::sum);
        }
        return totalAmounts;
    }
}