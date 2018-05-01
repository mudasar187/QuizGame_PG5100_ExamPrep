package com.quizgame.spring.selenium.po;

import com.quizgame.spring.selenium.PageObject;

public class LoginPO extends LayoutPO{

    public LoginPO(PageObject other) {
        super(other);
    }

    @Override
    public boolean isOnPage() {
        return getDriver().getTitle().contains("Log In");
    }

    public IndexPO enterCredentials(String userName, String password){

        setText("username", userName);
        setText("password", password);
        clickAndWait("submit");

        IndexPO po = new IndexPO(this);
        if(po.isOnPage()){
            return po;
        }

        return null;
    }
}
