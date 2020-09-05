package io.github.mchuhaievskyi.pomidor.database.labels;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class LabelDatabaseImpl implements LabelDatabase {

    private final static List<String> LABELS = new ArrayList<>();

    @Override
    public void add(String label) {

        LABELS.add(label);
    }

    @Override
    public boolean isPresent(String label) {

        return LABELS.contains(label);
    }
}