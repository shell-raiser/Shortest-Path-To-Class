package com.example.shortestpath;

import java.util.*;

public class Dijkstras {

    public List<Integer> M;

    //public static void main(String[] args) {
    //    createGraph(205,207);
    //}
    public static List<Integer> createGraph (int A,int B){
        A = A - 103;
        B = B - 103;
        char As = (char) A;
        char Bs = (char) B;
        Graph g = new Graph();
        /*g.addVertex('a', Arrays.asList(new Vertex('b', 7), new Vertex('c', 8)));
        g.addVertex('b', Arrays.asList(new Vertex('a', 7), new Vertex('f', 2)));
        g.addVertex('c', Arrays.asList(new Vertex('a', 8), new Vertex('f', 6), new Vertex('g', 4)));
        g.addVertex('d', Arrays.asList(new Vertex('f', 8)));
        g.addVertex('e', Arrays.asList(new Vertex('h', 1)));
        g.addVertex('f', Arrays.asList(new Vertex('b', 2), new Vertex('c', 6), new Vertex('d', 8), new Vertex('g', 9), new Vertex('h', 3)));
        g.addVertex('g', Arrays.asList(new Vertex('c', 4), new Vertex('f', 9)));
        g.addVertex('h', Arrays.asList(new Vertex('e', 1), new Vertex('f', 3)));*/
        //201
        g.addVertex('b', Arrays.asList(new Vertex('c', 938)));
        //202
        g.addVertex('c', Arrays.asList(new Vertex('b', 938), new Vertex('d', 929)));
        //203
        g.addVertex('d', Arrays.asList(new Vertex('c', 929), new Vertex('g', 600), new Vertex('e', 929)));
        //204
        g.addVertex('e', Arrays.asList(new Vertex('g', 304), new Vertex('f', 241), new Vertex('k', 2064), new Vertex('d', 929)));
        //205
        g.addVertex('f', Arrays.asList(new Vertex('e', 241)));
        //206
        g.addVertex('g', Arrays.asList(new Vertex('k', 2064), new Vertex('h', 203), new Vertex('e', 304), new Vertex('d', 600)));
        //207
        g.addVertex('h', Arrays.asList(new Vertex('g', 203), new Vertex('k', 2064)));
        //208
        g.addVertex('i', Arrays.asList(new Vertex('k', 536)));
        //209
        //g.addVertex('j', Arrays.asList(new Vertex('h', 1)));
        //210
        g.addVertex('k', Arrays.asList(new Vertex('l', 761), new Vertex('i', 536), new Vertex('g', 2064), new Vertex('h', 2064)));
        //211
        g.addVertex('l', Arrays.asList(new Vertex('k', 761), new Vertex('m', 1078)));
        //212
        g.addVertex('m', Arrays.asList(new Vertex('n', 1078), new Vertex('l', 1078)));
        //213
        g.addVertex('n', Arrays.asList(new Vertex('o', 1078), new Vertex('m', 1078)));
        //214
        g.addVertex('o', Arrays.asList(new Vertex('p', 1078), new Vertex('n', 1078)));
        //215
        g.addVertex('p', Arrays.asList(new Vertex('q', 114), new Vertex('o', 1078)));
        //216
        g.addVertex('q', Arrays.asList(new Vertex('r', 1127), new Vertex('p', 114)));
        //217
        g.addVertex('r', Arrays.asList(new Vertex('s', 667), new Vertex('q', 1127)));
        //218
        g.addVertex('s', Arrays.asList(new Vertex('u', 516), new Vertex('t', 100), new Vertex('r', 667)));
        //219
        g.addVertex('t', Arrays.asList(new Vertex('s', 100), new Vertex('u', 550)));
        //220
        g.addVertex('u', Arrays.asList(new Vertex('v', 1947), new Vertex('s', 516), new Vertex('t', 550)));
        //221
        g.addVertex('v', Arrays.asList(new Vertex('w', 317), new Vertex('u', 1947)));
        //222
        g.addVertex('w', Arrays.asList(new Vertex('x', 185), new Vertex('v', 317)));
        //223
        g.addVertex('x', Arrays.asList(new Vertex('w', 185)));
        // 223 to lift 2291
        //List<Integer> M = g.getShortestPath(A, B);
        //List<Integer> M = g.getShortestPath('d', 's');
        //System.out.println(g.getShortestPath( As, Bs));
        return g.getShortestPath(As, Bs);
        //printM();
        //System.out.println(M);
        // a is room 200
        //mapRoom = new mapRoom(K);

    }
    //public static void printM (){
    //    System.out.println(M);
    //}
    //List<Integer> K = M;
}

class Vertex implements Comparable<Vertex> {

    private Character id;
    private Integer distance;

    public Vertex(Character id, Integer distance) {
        super();
        this.id = id;
        this.distance = distance;
    }

    public Character getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((distance == null) ? 0 : distance.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (distance == null) {
            if (other.distance != null)
                return false;
        } else if (!distance.equals(other.distance))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vertex [id=" + id + ", distance=" + distance + "]";
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance)
            return -1;
        else if (this.distance > o.distance)
            return 1;
        else
            return this.getId().compareTo(o.getId());
    }

}

class Graph {

    private final Map<Character, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<Character, List<Vertex>>();
    }

    public void addVertex(Character character, List<Vertex> vertex) {
        this.vertices.put(character, vertex);
    }

    public List<Integer> getShortestPath(Character start, Character finish) {
        final Map<Character, Integer> distances = new HashMap<Character, Integer>();
        final Map<Character, Vertex> previous = new HashMap<Character, Vertex>();
        PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();

        for(Character vertex : vertices.keySet()) {
            if (vertex == start) {
                distances.put(vertex, 0);
                nodes.add(new Vertex(vertex, 0));
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
                nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
            }
            previous.put(vertex, null);
        }

        while (!nodes.isEmpty()) {
            Vertex smallest = nodes.poll();
            if (smallest.getId() == finish) {
                final List<Character> path = new ArrayList<Character>();
                while (previous.get(smallest.getId()) != null) {
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                List<Integer> newPath = new ArrayList<Integer>();
                for (Character ele : path) {
                    int ascii = (int) ele;
                    ascii = ascii + 103;
                    newPath.add(ascii);
                }
                return newPath;
            }

            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }

            for (Vertex neighbor : vertices.get(smallest.getId())) {
                Integer alt = distances.get(smallest.getId()) + neighbor.getDistance();
                if (alt < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);

                    forloop:
                    for(Vertex n : nodes) {
                        if (n.getId() == neighbor.getId()) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break forloop;
                        }
                    }
                }
            }
        }
        ArrayList<Character> charShortPath = new ArrayList<Character>(distances.keySet());

        List<Integer> newShortPath = new ArrayList<Integer>();
        for (Character ele : charShortPath) {
            int ascii = (int) ele;
            ascii = ascii + 103;
            newShortPath.add(ascii);
        }
        //System.out.println(newPath);
        //return new ArrayList<Character>(distances.keySet());
        return newShortPath;
    }

}

/*class mapRoom {
    //List<Integer> newPath = new ArrayList<Integer>();
    public mapRoom(List<Integer> K) {
        List<Integer> newPath = new ArrayList<Integer>();
    //}
    //public void mRgo(List<Character> K) {
            //System.out.println(newPath);
        for (Character ele : K) {
            int ascii = (int) ele;
            ascii = ascii + 103;
            newPath.add(ascii);
        }
        System.out.println(newPath);
    }
}*/
