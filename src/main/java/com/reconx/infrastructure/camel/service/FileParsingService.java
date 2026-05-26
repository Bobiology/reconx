package com.reconx.infrastructure.camel.service;

import com.reconx.domain.reconciliation.ReconciliationRecord;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileParsingService {

    public List<ReconciliationRecord> parseXlsx(
            InputStream inputStream
    ) {

        List<ReconciliationRecord> records =
                new ArrayList<>();

        try (Workbook workbook =
                     WorkbookFactory.create(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                ReconciliationRecord record =
                        new ReconciliationRecord();

                record.setReference(
                        row.getCell(0).getStringCellValue()
                );

                record.setAmount(
                        BigDecimal.valueOf(
                                row.getCell(1)
                                        .getNumericCellValue()
                        )
                );

                records.add(record);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to parse XLSX",
                    e
            );
        }

        return records;
    }
}