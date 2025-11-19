package com.proxy.personaltain.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//) 요구 기능 1 – userId별 총 주문 금액 Map 만들기
//	•	결과 타입: Map<String, Integer> (또는 long)
//	•	key  : userId
//	•	value: 그 유저의 총 amount 합

//요구 기능 2 – itemName별 주문 횟수 Map 만들기
//	•	결과 타입: Map<String, Integer>
//	•	key  : itemName
//	•	value: 그 상품이 몇 번 주문됐는지(건수)
public class Mission2 {
    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("user1", "APPLE", 1000));
        orders.add(new Order("user1", "BANANA", 2000));
        orders.add(new Order("user2", "APPLE", 1500));
        orders.add(new Order("user2", "CARROT", 500));
        orders.add(new Order("user3", "BANANA", 700));

        System.out.println("오더 확인 " + orders);


        Map<String, Integer> totalAmountByUser = new HashMap<>();
        Map<String, Integer> totalitemCheck = new HashMap<>();

        for (Order order : orders) {
            String userId = order.getUserId();
            if (totalAmountByUser.containsKey(userId)) {
                int totalAmount = totalAmountByUser.get(userId);
                totalAmount += order.getAmount();
                totalAmountByUser.put(userId, totalAmount);
            } else {
                totalAmountByUser.put(userId, order.getAmount());
            }

            String itemName = order.getItemName();
            int count = totalitemCheck.getOrDefault(itemName, 0);
            totalitemCheck.put(itemName, count + 1);


        }

        System.out.println("요구사항 1 " + totalAmountByUser.toString());
        System.out.println("요구사항 2 " + totalitemCheck.toString());





    }
}

class Order {
    private String userId;   // 주문한 유저 ID
    private String itemName; // 상품 이름
    private int amount;

    public Order(String userId, String itemName, int amount) {
        this.userId = userId;
        this.itemName = itemName;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
