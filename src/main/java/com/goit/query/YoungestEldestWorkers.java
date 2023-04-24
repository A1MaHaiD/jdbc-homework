package com.goit.query;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@ToString
@AllArgsConstructor
public class YoungestEldestWorkers {
    private String type; //private Type type; //(enum)
    private String name;
    private Date birthday;
}