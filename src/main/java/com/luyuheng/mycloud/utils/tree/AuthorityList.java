package com.luyuheng.mycloud.utils.tree;

import com.luyuheng.mycloud.pojo.Authority;

import java.util.List;

/**
 * @Author:luyuheng
 * @Date:2018/4/28 11 25
 * @Description
 */
public class AuthorityList {

    private Authority authority;

    private List<Authority> authorityList;

    @Override
    public String toString() {
        return "AuthorityList{" +
                "authority=" + authority +
                ", authorityList=" + authorityList +
                '}';
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
