package com.snap.food;

import com.snap.food.controller.FoodService;
import com.snap.food.controller.IdGenerator;
import com.snap.food.controller.OrderService;
import com.snap.food.controller.UserService;
import com.snap.food.model.dao.FoodDao;
import com.snap.food.model.dao.OrderDao;
import com.snap.food.model.dao.UserDao;
import com.snap.food.model.domain.Food;
import com.snap.food.model.domain.Order;
import com.snap.food.model.domain.User;

import java.io.IOException;
import java.time.Instant;
import java.util.*;


public class MainClass {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            UserDao userDao = new UserDao();
            FoodDao foodDao = new FoodDao();
            OrderDao orderDao = new OrderDao();
            IdGenerator idGenerator = new IdGenerator(userDao,orderDao ,foodDao);

            UserService userService = new UserService(userDao,foodDao,orderDao, idGenerator);
            OrderService orderService = new OrderService(userDao,foodDao,orderDao, idGenerator);
            FoodService foodService = new FoodService(foodDao);

            registerFood(foodService,idGenerator);
            User loggedInUser = null;
            Boolean correctInput=true;



            while (loggedInUser == null && correctInput) {
                try {
                    System.out.println("*******************  menu  **********************");
                    System.out.println("    10- login");
                    System.out.println("    20- register");
                    System.out.println("**********************************************");
                    System.out.println("please enter your selection:");

                    switch (scanner.nextInt()) {
                        case 10:
                            System.out.println("please enter your username : ");
                            loggedInUser = userService.login(scanner.nextInt());
                            break;
                        case 20:{
                            User user = new User();
                            user.setId(idGenerator.nextOrderId());
                            System.out.println("please enter your name :");
                            String name = scanner.next();
                            user.setName(name);

                            System.out.println("please enter your family :");
                            String family = scanner.next();
                            user.setFamily(family);

                            System.out.println("please enter your address :");
                            String address = scanner.next();
                            user.setAddress(address);

                            System.out.println("please enter your phone :");
                            String phone = scanner.next();
                            user.setPhone(phone);

                            System.out.println("please enter your username :");
                            String username = scanner.next();
                            user.setUsername(username);
                            loggedInUser = userService.register(user);
                            System.out.println("registered...");
                            break;
                        }
                        default:
                            System.out.println("your input is incorrect!!");
                            correctInput=false;

                    }

                } catch (Exception e) {
                    correctInput=false;
                }
            }
            if (correctInput){

                System.out.println("welcome dear "  + loggedInUser.getName());

                System.out.println("*******************  menu  **********************");
                System.out.println("    30- menu");
                System.out.println("    40- order food");
                System.out.println("    50- exit");
                System.out.println("**************************************************");

                boolean running = true;

                while (running) {


                    switch (scanner.nextInt()) {
                        case 30:{
                            showMenu(foodService).stream().forEach(food -> {
                                System.out.println("FOOD ID :: "+food.getId()+" | FOOD NAME:: "+food.getFoodName()+" | FOOD PRICE :: "+food.getPrice());
                            });
                            System.out.println("please select the food from our menu:");
                            System.out.println("if you are not sure please press 5 to exit...");
                            orderFood(orderService,idGenerator,Integer.valueOf(scanner.next()),loggedInUser.getId());
                            running = false;
                            break;
                        }
                        case 40:{
                            System.out.println("please enter Food Id,If you don't know please press 0 then select from our menu:");
                            Integer selectId=Integer.valueOf(scanner.next());
                            if (selectId!=0){
                                orderFood(orderService,idGenerator,selectId,loggedInUser.getId());
                                running = false;
                            }else {
                                System.out.println("*******************  menu  **********************");
                                System.out.println("    30- menu");
                                System.out.println("    40- order food");
                                System.out.println("    50- exit");
                                System.out.println("**************************************************");
                            }
                            break;
                        }
                        case 50:
                            running = false;
                            break;
                        default:
                            System.out.println("wrong input!");
                    }

                }
            }



        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getCause());
        }
    }
    private static Collection<Food> showMenu(FoodService foodService) {
       return foodService.getAll();
    }
    private static void orderFood(OrderService orderService,IdGenerator idGenerator ,Integer foodId,Integer userId) throws IOException {
        Order order = new Order();
        order.setId(idGenerator.nextOrderId());
        order.setFoodId(foodId);
        order.setRegisterDate(Instant.now());
        order.setUserId(userId);
        orderService.register(order);
        System.out.println("thank you for your order,it's registered");
//        System.out.println();
    }

    private static void registerFood(FoodService foodService,IdGenerator idGenerator) throws IOException {
        Food food = new Food();
        food.setId(idGenerator.nextFoodId());
        food.setFoodName("Pizza");
        food.setPrice(20000);
        foodService.register(food);
        Food food1 = new Food();
        food1.setFoodName("chicken");
        food1.setPrice(50000);
        food1.setId(idGenerator.nextFoodId());
        foodService.register(food1);
    }


}
