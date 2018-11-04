/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.tree;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.ui.uielement.UiElement;
import com.bsptechs.main.bean.ui.uielement.data.UiElementData;
import com.bsptechs.main.bean.ui.uielement.data.UiElementDataConnection;
import com.bsptechs.main.util.MouseUtil;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.soap.Node;

/**
 *
 * @author sarkhanrasullu
 */
public class CustomJTree extends JTree {

    public CustomJTree() {
        this.addMouseListener(getAdapter());
        this.setCellRenderer(new CustomTreeCellRenderer());
    }

    public UiElement getSelectedUiElement() {
        DefaultMutableTreeNode obj = getSelectedNode();
        if (obj != null && obj.getUserObject() instanceof UiElement) {
            return (UiElement) obj.getUserObject();
        }
        return null;
    }

    public DefaultMutableTreeNode getSelectedNode() {
        TreePath selectionPath = this.getSelectionPath();
        if (selectionPath != null) {
            DefaultMutableTreeNode obj = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
            return obj;
        }
        return null;
    }

    public DefaultMutableTreeNode findNode(String nodeTitle) {
        DefaultTreeModel model = (DefaultTreeModel) this.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        Enumeration e = root.children();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            UiElement uiElement = (UiElement) node.getUserObject();
            System.out.println(uiElement.getText());
            if (uiElement.getText().equals(nodeTitle)) {
                return node;
            }
        }
        return null;
    }

//    public DefaultMutableTreeNode addUiElement(UiElement element) {
//        DefaultMutableTreeNode root = getRoot();
//        if (getSelectedUiElement() != null) {
//            root = getSelectedNode();
//            root.removeAllChildren();
//        }
//        return addUiElement(element, root);
//    }
    public DefaultMutableTreeNode addUiElement(UiElement element, DefaultMutableTreeNode root) {
        DefaultTreeModel model = (DefaultTreeModel) this.getModel();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(element);
        model.insertNodeInto(node, root, root.getChildCount());
        return node;
    }

    public void expand(DefaultMutableTreeNode node) {
        this.expandPath(new TreePath(node.getPath()));
    }

    public void fillTree(List<? extends UiElementData> listData, DefaultMutableTreeNode root) {
        if (listData == null) {
            return;
        }

        for (UiElementData t : listData) {
            UiElement uiElement = new UiElement(t.toString());
            uiElement.setData(t);
            DefaultMutableTreeNode addEl = addUiElement(uiElement, root);

            if (t.getSubList() != null) {
                fillTree(t.getSubList(), addEl);
            }
        }
    }

    public void fillTree(List<? extends UiElementData> listData) {
        fillTree(listData, getRoot());
    }

    private DefaultMutableTreeNode getRoot() {
        DefaultTreeModel model = (DefaultTreeModel) this.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        return root;
    }

    public void refresh() {
        List<UiElementDataConnection> connections = Config.instance().getConnections();
        DefaultTreeModel model = (DefaultTreeModel) this.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        model.reload();
        fillTree(connections);
        setNodeExpandedState(this, root);
    }

    public MouseAdapter getAdapter() {
        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UiElement element = getSelectedUiElement();
                if (element == null) {
                    return;
                }
                UiElementData data = element.getData();
                if (MouseUtil.isRightClicked(evt)) {
                    int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
                    int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
                    data.getPopup().show(Config.getMain(), mouseX, mouseY - 5);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (MouseUtil.isLeftDoubleClicked(evt)) {
                    DefaultMutableTreeNode selectedNode = getSelectedNode();
                    UiElement element = (UiElement) selectedNode.getUserObject();
                    if (element == null) {
                        return;
                    }
                    if (element.getData() instanceof UiElementData) {
                        UiElementData data = (UiElementData) element.getData();
                        data.onDoubleClick();
                        System.out.println("data.isExpanded()="+data.isExpanded());
                        if(data.isExpanded())
                            expand(selectedNode);
                    }
                }
            }
        };

        return m;
    }

    public static void setNodeExpandedState(JTree tree, DefaultMutableTreeNode node) {
        ArrayList<DefaultMutableTreeNode> list = Collections.list(node.children());
        for (DefaultMutableTreeNode treeNode : list) {
            setNodeExpandedState(tree, treeNode);
        }

        TreePath path = new TreePath(node.getPath());
        if (node.getUserObject() instanceof UiElement) {
            UiElement ui = (UiElement) node.getUserObject();
            if (ui.getData().isExpanded()) {
                tree.expandPath(path);
            }
        }

    }

}
