package com.goit.query.tables;

import com.goit.emums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Worker {
    String name;
    Date birthday;
    String level;
    int salary;

    public Worker() {

    }
}