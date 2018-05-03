package com.luyuheng.mycloud.utils.tree;

import com.luyuheng.mycloud.pojo.Authority;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:luyuheng
 * @Date:2018/4/28 10 47
 * @Description
 */
public class AuthorityTreeNode {

    private Authority authority;

    private List<AuthorityTreeNode> children;

    public AuthorityTreeNode(Authority auth){
        this.authority = auth;
        this.children = new ArrayList<AuthorityTreeNode>();
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public List<AuthorityTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<AuthorityTreeNode> children) {
        this.children = children;
    }
}
