package com.goit.query.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Project {
    int clientId;
    Date startDate;
    Date finishDate;
}
