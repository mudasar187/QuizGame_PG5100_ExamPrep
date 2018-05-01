package com.quizgame.spring.selenium.po;

import com.quizgame.spring.selenium.PageObject;

public class AdminPO extends LayoutPO {

    public AdminPO(PageObject other) {
        super(other);
    }

    @Override
    public boolean isOnPage() {
        return getDriver().getTitle().contains("Admin");
    }
}
