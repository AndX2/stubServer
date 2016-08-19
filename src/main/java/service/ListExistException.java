package service;

public class ListExistException extends Exception{
    private String existList;

    public void setExistList(String list){
        existList = list;
    }

    public String getExistList(){
        return existList;
    }

}
