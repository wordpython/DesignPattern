package com.wordpython.principle.inversion;

/**
 * @Author wordpython
 * @Date 2019/12/17
 **/

public class DependencyPass {
    public static void main(String[] args) {
        ChangHong changHong = new ChangHong();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(changHong);
    }
}

interface IOpenAndClose{
    public void open(ITV tv);
}
interface ITV{
    public void play();
}
class ChangHong implements ITV{
    @Override
    public void play() {
        System.out.println("长虹电视 打开");
    }
}
class OpenAndClose implements IOpenAndClose{
    @Override
    public void open(ITV tv) {
        tv.play();
    }
}