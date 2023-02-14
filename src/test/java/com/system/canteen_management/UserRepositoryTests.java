package com.system.canteen_management;


import com.system.canteen_management.entity.user_management.User;
import com.system.canteen_management.repo.user_management.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {
        User user= User.builder()
                .fullName("hari shrestha")
                .email("hsharan.shresths@gmail.com")
                .mobileNo("9812312312")
                .image("test.jpg")
                .password("test123")
                .build();

        userRepo.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public  void getUserTest(){
        User userGet= userRepo.findById(1).get();
        Assertions.assertThat(userGet.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfUserTest(){
        List<User> users = userRepo.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCustomerTest(){
        User user = userRepo.findById(1).get();
        user.setFullName("sajak shrestha");
        User userUpdated =  userRepo.save(user);

        Assertions.assertThat(userUpdated.getFullName()).isEqualTo("sajak shrestha");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user = userRepo.findById(1).get();
        userRepo.delete(user);

        User user1 = null;
        Optional<User> opUser = userRepo.findUserByFullName("sajak shrestha");
        if(opUser.isPresent()){
            user1 = opUser.get();
        }
        Assertions.assertThat(user1).isNull();
    }


}
