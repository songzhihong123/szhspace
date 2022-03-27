package com.song;

/**
 * 路径压缩.
 */
//第五版的Union-Find
public class UnionFind5 implements UF {

    private int[] parent;
    private int[] rank;  //rank[i] 表示以i为根的所表示数的层数

    public UnionFind5(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    //查找过程，查找元素p所对应的集合编号
    //O(h) 复杂度，h 为树的高度
    private int find(int p){
        if (p < 0 || p > parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        //这是一个不断索引的过程，不是访问一段连续的空间
        while(parent[p] != p){
            //并查集经典优化：路径压缩
            // 将 p 节点的父亲 设置为 p节点父亲的父亲
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    //查看元素p和元素q是否所属一个集合
    //O(h)复杂度，h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合
    //O(h)复杂度，h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;

        //根据两个元素所在树的元素个数不同判断合并的方向
        //将rank低的集合合并到rank高的集合上
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{ //rank[pRoot] == rank[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }
}
