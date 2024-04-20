package kz.kstu.fit.sib.group_22_5.st_Popov.course_work.actions;

import kz.kstu.fit.sib.group_22_5.st_Popov.course_work.entities.Client;

import java.util.List;

public interface Searchable {
    boolean search(String query, List<Client> clients);
}
