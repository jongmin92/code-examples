package com.jongmin.ex;

public class DefaultRepository implements Repository {

    @Transactional
    @Override
    public void yesTransaction() {
        System.out.println("yesTransaction");
    }

    @Override
    public void noTransaction() {
        System.out.println("noTransaction");
    }
}
