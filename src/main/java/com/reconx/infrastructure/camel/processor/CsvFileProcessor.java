package com.reconx.infrastructure.camel.processor;

import com.reconx.domain.reconciliation.ReconciliationRecord;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvFileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {

        String body =
                exchange.getIn().getBody(String.class);

        String[] lines = body.split("\n");

        List<ReconciliationRecord> records =
                new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {

            String[] cols = lines[i].split(",");

            ReconciliationRecord record =
                    new ReconciliationRecord();

            record.setReference(cols[0]);

            record.setAmount(new BigDecimal(Double.parseDouble(cols[1])));

            records.add(record);
        }

        exchange.getIn().setBody(records);
    }
}
