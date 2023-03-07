package top.flobby.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.flobby.spring.entity.CardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description :
 * @create : 2023-03-07 19:38
 **/

@Controller
public class ShowListController {

    @GetMapping("list")
    public ModelAndView getList() {
        CardItem cardItem1 = new CardItem("Microservices", "1.jpg", "Quickly deliver production‑grade features with independently evolvable microservices.");
        CardItem cardItem2 = new CardItem("Reactive", "2.jpg", "Spring's asynchronous, nonblocking architecture means you can get more from your computing resources.");
        CardItem cardItem3 = new CardItem("Cloud", "3.jpg", "Your code, any cloud—we’ve got you covered. Connect and scale your services, whatever your platform.");
        CardItem cardItem4 = new CardItem("Web apps", "4.jpg", "Frameworks for fast, secure, and responsive web applications connected to any data store.");
        CardItem cardItem5 = new CardItem("Serverless", "5.jpg", "The ultimate flexibility. Scale up on demand and scale to zero when there’s no demand.");
        CardItem cardItem6 = new CardItem("Event Driven", "6.jpg", "Integrate with your enterprise. React to business events. Act on your streaming data in realtime.");
        CardItem cardItem7 = new CardItem("Batch", "7.jpg", "Automated tasks. Offline processing of data at a time to suit you.");
        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(cardItem1);
        cardItemList.add(cardItem2);
        cardItemList.add(cardItem3);
        cardItemList.add(cardItem4);
        cardItemList.add(cardItem5);
        cardItemList.add(cardItem6);
        cardItemList.add(cardItem7);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", cardItemList);
        return modelAndView;
    }
}
