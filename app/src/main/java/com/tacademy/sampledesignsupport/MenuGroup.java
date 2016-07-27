package com.tacademy.sampledesignsupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-27.
 */
public class MenuGroup {
    public String groupName;
    public int groupId;
    public List<MenuChild> children = new ArrayList<>();

    public MenuGroup(String groupName, int groupId, MenuChild... children) {
        this.groupName = groupName;
        this.groupId = groupId;
        this.children.addAll(Arrays.asList(children));
    }
}
