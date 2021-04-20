package com.example.myapplication;

public class ItemListResponse {
    int id;
    int listId;
    String name;

    public ItemListResponse() {

    }

    public ItemListResponse(int id, int listId, String name) {
        this.name = name;
        this.id = id;
        this.listId = listId;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", listId=" + listId +
                ", name='" + name + '\''
                ;
    }
}
