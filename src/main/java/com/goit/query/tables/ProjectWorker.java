package com.goit.query.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProjectWorker {
    int workerId;
    int projectId;

    public ProjectWorker() {

    }
}
