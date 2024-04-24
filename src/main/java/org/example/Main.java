package org.example;
//        Participant client = new Participant
//                ("dfd", 20, "dfdf", "dff", 1, 1, 1, "dfdf");
//
//        ApplicationGui applicationGui = new ApplicationGui();
//        applicationGui.setVisible(true);
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new ApplicationGui().setVisible(true);
//            }
//        });
import guis.ApplicationGui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

       List<Example> pairs = createPairs();
       List<ExGr> groups = createGroups(pairs);
       printGroups(groups);



    }
    
    public static List<Example> createPairs() {
        List<Example> examples = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Example example = new Example("Pair_" + i);
            examples.add(example);
        }
        return examples;
    }


    public static List<ExGr> createGroups(List<Example> pairs) {
        List<ExGr> groups = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i+=3) {
            if (i + 3 >= pairs.size()) {
                break;
            }
            ExGr gr = new ExGr(i);
            int temp = i;
            for (int j = i; j < i+3; j++) {
                gr.add(pairs.get(j));
            }
            setCoocker(gr);
            groups.add(gr);

        }
        return groups;
    }

    public static void setCoocker(ExGr gr) {
        for (int i = 0; i < gr.getGroup().size(); i++) {
            if (gr.getGroup().get(i).coocked == false) {
                gr.getGroup().get(i).coocked = true;
            }
            break;
        }
    }

    public static void printGroups(List<ExGr> groups) {
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("Group id" + groups.get(i).id);
            groups.get(i).print();
        }
    }


}