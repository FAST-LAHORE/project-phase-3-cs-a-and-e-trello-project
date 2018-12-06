/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trello;

import java.util.ArrayList;

/**
 *
 * @author ubaidullah
 */
public class CheckList {
    ArrayList<Item> ItemsIncluded;
    
    String name;
    public CheckList(String n) {
    ItemsIncluded=new ArrayList<Item>();
    
    name=n;
    }
    void AddItem(String x){
        Item i=new Item(x);
        ItemsIncluded.add(i);
    }
    
}
