package com.example.fastrecklessbank.data;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transfer {
        private String id;
        private String type;
        private LocalDate date;
        private BigDecimal amount;


        public Transfer(String id, String type, LocalDate date, BigDecimal amount) {
            this.id = id;
            this.type = type;
            this.date = date;
            this.amount = amount;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
}
