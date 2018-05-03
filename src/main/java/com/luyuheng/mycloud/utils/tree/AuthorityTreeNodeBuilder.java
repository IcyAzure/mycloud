package com.luyuheng.mycloud.utils.tree;

import com.luyuheng.mycloud.pojo.Authority;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:luyuheng
 * @Date:2018/4/28 10 48
 * @Description
 */
public class AuthorityTreeNodeBuilder {

    private AuthorityTreeNode root;

    private List<Authority> authorityList;

    public AuthorityTreeNode buildTree(List<Authority> authorities){
        this.authorityList = authorities;
        this.root = findRoot();
        return recursive(root);
    }

    private AuthorityTreeNode recursive(AuthorityTreeNode node){
        node.setChildren(findChildrenByParentId(node.getAuthority().getId()));
        for (AuthorityTreeNode childeNode:node.getChildren()){
            recursive(childeNode);
        }
        return node;
    }

    private List<AuthorityTreeNode> findChildrenByParentId(String parentId){
        List<AuthorityTreeNode> childList = new ArrayList<>();
        for (Authority auth:authorityList){
            if (parentId.equals(auth.getParentId())){
                childList.add(new AuthorityTreeNode(auth));
            }
        }
        return childList;
    }

    private AuthorityTreeNode findRoot() {
        for (Authority auth:authorityList){
            if (auth.getLevel() == 1){
                authorityList.remove(auth);
                return new AuthorityTreeNode(auth);
            }
        }
        return null;
    }
}
