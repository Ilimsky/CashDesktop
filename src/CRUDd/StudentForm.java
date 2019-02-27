package CRUDd;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class StudentForm extends JFrame {

    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final String dbUrl = "jdbc:jtds:sqlserver://sql6005.site4now.net/DB_A44BEF_ilimsky";
    private static final String dbUser = "DB_A44BEF_ilimsky_admin";
    private static final String dbPassword = "P@ssw0rd";
    private static final String path = "C:\\Users\\User\\Desktop\\student_list.txt";
    private int i = 0;
    private String firstName;
    private String lastName;
    private String email;
    private String day;
    private String month;
    private String year;
    private String dateOfBirth;
    private String comments;
    private String errorMessage;

    public StudentForm() {
        initComponents();
        firstNameTextField.setEnabled(false);
        lastNameTextField.setEnabled(false);
        emailTextField.setEnabled(false);
        dayTextField.setEnabled(false);
        monthTextField.setEnabled(false);
        yearTextField.setEnabled(false);
        commentsTextField.setEnabled(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        getDbQuery(studentList,dbUrl, dbUser, dbPassword);
        firstNameTextField.setText(studentList.get(i).getFirstName());
        lastNameTextField.setText(studentList.get(i).getLastName());
        emailTextField.setText(studentList.get(i).getEmail());
        if (studentList.get(i).getDateOfBirth().toString() == "") {
            dayTextField.setText("");
            monthTextField.setText("");
            yearTextField.setText("");
        } else {
            if(studentList.get(i).getDateOfBirth().length() == 10) {
                dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
                monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
                yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
            } else {
                dayTextField.setText("");
                monthTextField.setText("");
                yearTextField.setText("");
            }
        }
        commentsTextField.setText(studentList.get(i).getComments());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        monthTextField = new javax.swing.JTextField();
        commentsTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        commentsLabel = new javax.swing.JLabel();
        studentFormTitleLabel = new javax.swing.JLabel();
        firstButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        addNewButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        dayTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        forwardSlashLabel1 = new javax.swing.JLabel();
        forwardSlashLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        emailLabel.setText("Email:");

        dateOfBirthLabel.setText("Date of Brith:");

        commentsLabel.setText("Comments:");

        studentFormTitleLabel.setText("Student Contact Form");

        firstButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        firstButton.setText("First");
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });

        previousButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        lastButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        lastButton.setText("Last");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        addNewButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        addNewButton.setText("Add New");
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        printButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        forwardSlashLabel1.setText("/");

        forwardSlashLabel2.setText("/");

        saveButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(studentFormTitleLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(firstButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(previousButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(nextButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lastButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(exitButton))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(firstNameLabel)
                                                                        .addComponent(lastNameLabel)
                                                                        .addComponent(emailLabel)
                                                                        .addComponent(dateOfBirthLabel)
                                                                        .addComponent(commentsLabel))
                                                                .addGap(24, 24, 24)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(firstNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(3, 3, 3)
                                                                                .addComponent(forwardSlashLabel1)
                                                                                .addGap(3, 3, 3)
                                                                                .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(commentsTextField))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(addNewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                                                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(saveButton)
                                                                        .addComponent(cancelButton))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(203, 203, 203)
                                        .addComponent(forwardSlashLabel2)
                                        .addContainerGap(162, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(studentFormTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstNameLabel)
                                        .addComponent(addNewButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameLabel)
                                        .addComponent(deleteButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateOfBirthLabel)
                                                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(forwardSlashLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(2, 2, 2)))
                                        .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(commentsLabel)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(commentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelButton)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(saveButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(printButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstButton)
                                        .addComponent(previousButton)
                                        .addComponent(nextButton)
                                        .addComponent(lastButton)
                                        .addComponent(exitButton))
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(forwardSlashLabel2)
                                        .addContainerGap(161, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        disableTextFieldsAndButtons();
    }//GEN-LAST:event_addNewButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        i = 0;
        firstNameTextField.setText(studentList.get(i).getFirstName());
        lastNameTextField.setText(studentList.get(i).getLastName());
        emailTextField.setText(studentList.get(i).getEmail());
        dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
        monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
        yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
        commentsTextField.setText(studentList.get(i).getComments());
    }//GEN-LAST:event_firstButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        i = studentList.size() - 1;
        firstNameTextField.setText(studentList.get(i).getFirstName());
        lastNameTextField.setText(studentList.get(i).getLastName());
        emailTextField.setText(studentList.get(i).getEmail());
        dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
        monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
        yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
        commentsTextField.setText(studentList.get(i).getComments());
    }//GEN-LAST:event_lastButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (i != 0) {
            i = i - 1;
            firstNameTextField.setText(studentList.get(i).getFirstName());
            lastNameTextField.setText(studentList.get(i).getLastName());
            emailTextField.setText(studentList.get(i).getEmail());
            dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
            monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
            yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
            commentsTextField.setText(studentList.get(i).getComments());
        } else {
            i = studentList.size() - 1;
            firstNameTextField.setText(studentList.get(i).getFirstName());
            lastNameTextField.setText(studentList.get(i).getLastName());
            emailTextField.setText(studentList.get(i).getEmail());
            dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
            monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
            yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
            commentsTextField.setText(studentList.get(i).getComments());
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (i != studentList.size() - 1) {
            i = i + 1;
            firstNameTextField.setText(studentList.get(i).getFirstName());
            lastNameTextField.setText(studentList.get(i).getLastName());
            emailTextField.setText(studentList.get(i).getEmail());
            dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
            monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
            yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
            commentsTextField.setText(studentList.get(i).getComments());
        } else {
            i = 0;
            firstNameTextField.setText(studentList.get(i).getFirstName());
            lastNameTextField.setText(studentList.get(i).getLastName());
            emailTextField.setText(studentList.get(i).getEmail());
            dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
            monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
            yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
            commentsTextField.setText(studentList.get(i).getComments());
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            int countRows;
            firstName = firstNameTextField.getText();
            lastName = lastNameTextField.getText();
            email = emailTextField.getText();
            day = dayTextField.getText();
            month = monthTextField.getText();
            year = yearTextField.getText();
            comments = commentsTextField.getText();
            if (day.length() == 2) {
                day = dayTextField.getText();
            } else if (day.length() == 1) {
                day = "0" + dayTextField.getText();
            } else {
                dayTextField.setText("");
                errorMessage = day + " is not a valid format for dd/MM/yyyy";
                JOptionPane.showMessageDialog(null, errorMessage, "MESSAGE", JOptionPane.OK_OPTION);
            }
            if (month.length() == 2) {
                month = monthTextField.getText();
            } else if (month.length() == 1) {
                month = "0" + monthTextField.getText();
            } else {
                monthTextField.setText("");
                errorMessage = month + " is not a valid format for dd/MM/yyyy";
                JOptionPane.showMessageDialog(null, errorMessage, "MESSAGE", JOptionPane.OK_OPTION);
            }
            if (year.length() == 4) {
                year = yearTextField.getText();
                int yearValue = Integer.parseInt(year);
                if (yearValue < 1893) {
                    yearTextField.setText("");
                    errorMessage = year + " is not a valid year.";
                    JOptionPane.showMessageDialog(null, errorMessage, "MESSAGE", JOptionPane.OK_OPTION);
                } else if (yearValue > 2006) {
                    yearTextField.setText("");
                    errorMessage = year + " is less than 13 years old.";
                    JOptionPane.showMessageDialog(null, errorMessage, "MESSAGE", JOptionPane.OK_OPTION);
                }
            } else {
                yearTextField.setText("");
                errorMessage = year + " is not a valid format for dd/MM/yyyy";
                JOptionPane.showMessageDialog(null, errorMessage, "MESSAGE", JOptionPane.OK_OPTION);
            }
            if (comments.length() > 250) {
                commentsTextField.setText("");
                errorMessage = comments + " is too long, it must be less than 250 characters.";
                JOptionPane.showMessageDialog(null, errorMessage, "MESSAGE", JOptionPane.OK_OPTION);
            } else {
                comments = commentsTextField.getText();
            }
            dateOfBirth = day + "/" + month + "/" + year;
            countRows = checkRowDbQuery(firstName, lastName, email, dateOfBirth, comments, dbUrl, dbUser, dbPassword);
            if(countRows == 0 && firstName != null && lastName != null && dateOfBirth != null &&
                    email != null && comments != null){
                insertDbQuery(firstName, lastName, email, dateOfBirth, comments, dbUrl, dbUser, dbPassword);
                lastRow();
                enableTextFieldsAndButtons();
            } else {
                errorMessage = "Record already exists, please insert a new record or problem inserting data.";
                JOptionPane.showMessageDialog(null, errorMessage, "MESSAGE", JOptionPane.OK_OPTION);
            }

        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        enableTextFieldsAndButtons();
        getDbQuery(studentList,dbUrl, dbUser, dbPassword);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        firstName = firstNameTextField.getText();
        lastName = lastNameTextField.getText();
        email = emailTextField.getText();
        deleteDbQuery(firstName, lastName, email,
                dbUrl, dbUser, dbPassword);
        studentList.remove(i);
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        emailTextField.setText("");
        dayTextField.setText("");
        monthTextField.setText("");
        yearTextField.setText("");
        commentsTextField.setText("");
        if (studentList.size() == 0) {
            i = 0;
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            dayTextField.setText("");
            monthTextField.setText("");
            yearTextField.setText("");
            commentsTextField.setText("");
        } else if (studentList.get(i).equals(0)) {
            i = studentList.size() - 1;
            firstNameTextField.setText(studentList.get(i).getFirstName());
            lastNameTextField.setText(studentList.get(i).getLastName());
            emailTextField.setText(studentList.get(i).getEmail());
            dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
            monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
            yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
            commentsTextField.setText(studentList.get(i).getComments());
        } else {
            i = i - 1;
            firstNameTextField.setText(studentList.get(i).getFirstName());
            lastNameTextField.setText(studentList.get(i).getLastName());
            emailTextField.setText(studentList.get(i).getEmail());
            dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
            monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
            yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
            commentsTextField.setText(studentList.get(i).getComments());
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        writeToFile(studentList);
    }//GEN-LAST:event_printButtonActionPerformed

    private void enableTextFieldsAndButtons() {
        firstButton.setEnabled(true);
        previousButton.setEnabled(true);
        nextButton.setEnabled(true);
        lastButton.setEnabled(true);
        addNewButton.setEnabled(true);
        deleteButton.setEnabled(true);
        printButton.setEnabled(true);
        firstNameTextField.setEnabled(false);
        lastNameTextField.setEnabled(false);
        emailTextField.setEnabled(false);
        dayTextField.setEnabled(false);
        monthTextField.setEnabled(false);
        yearTextField.setEnabled(false);
        commentsTextField.setEnabled(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
    }

    private void disableTextFieldsAndButtons() {
        firstButton.setEnabled(false);
        previousButton.setEnabled(false);
        nextButton.setEnabled(false);
        lastButton.setEnabled(false);
        addNewButton.setEnabled(false);
        deleteButton.setEnabled(false);
        printButton.setEnabled(false);
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        emailTextField.setText("");
        dayTextField.setText("");
        monthTextField.setText("");
        yearTextField.setText("");
        commentsTextField.setText("");
        firstNameTextField.setEnabled(true);
        lastNameTextField.setEnabled(true);
        emailTextField.setEnabled(true);
        dayTextField.setEnabled(true);
        monthTextField.setEnabled(true);
        yearTextField.setEnabled(true);
        commentsTextField.setEnabled(true);
        saveButton.setVisible(true);
        cancelButton.setVisible(true);
    }

    private void lastRow() {
        studentList.clear();
        getDbQuery(studentList, dbUrl, dbUser, dbPassword);
        i = studentList.size() - 1;
        firstNameTextField.setText(studentList.get(i).getFirstName());
        lastNameTextField.setText(studentList.get(i).getLastName());
        emailTextField.setText(studentList.get(i).getEmail());
        dayTextField.setText(studentList.get(i).getDateOfBirth().substring(0, 2));
        monthTextField.setText(studentList.get(i).getDateOfBirth().substring(3, 5));
        yearTextField.setText(studentList.get(i).getDateOfBirth().substring(6, 10));
        commentsTextField.setText(studentList.get(i).getComments());
    }

    private static ArrayList<Student> getDbQuery(ArrayList<Student> studentList, String dbUrl, String dbUser, String dbPassword) {
        Student student;
        try {
            Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FirstName, LastName, Email, DateOfBirth, Comments FROM dbo.StudentInformation");

            String firstName;
            String lastName;
            String email;
            String dateOfBirth;
            String comments;
            int count = 0;

            while(resultSet.next()){
                student = new Student();
                if (resultSet.getString("FirstName").isEmpty()) {
                    firstName = "";
                } else {
                    firstName = resultSet.getString("FirstName");
                }
                if (resultSet.getString("LastName").isEmpty()) {
                    lastName = "";
                } else {
                    lastName = resultSet.getString("LastName");
                }
                if (resultSet.getString("Email").isEmpty()) {
                    email = "";
                } else {
                    email = resultSet.getString("Email");
                }
                if (resultSet.getString("DateOfBirth").isEmpty()) {
                    dateOfBirth = "";
                } else {
                    dateOfBirth = resultSet.getString("DateOfBirth");
                }
                if (resultSet.getString("Comments").isEmpty()) {
                    comments = "";
                } else {
                    comments = resultSet.getString("Comments");
                }
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setDateOfBirth(dateOfBirth);
                student.setComments(comments);
                studentList.add(student);
                count++;
            }
            if (count < 1){
                student = new Student();
                firstName = "";
                lastName = "";
                email = "";
                dateOfBirth = "";
                comments = "";
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setDateOfBirth(dateOfBirth);
                student.setComments(comments);
                studentList.add(student);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return studentList;
    }

    private void insertDbQuery(String firstName, String lastName, String email, String dateOfBirth, String comments,
                               String dbUrl, String dbUser, String dbPassword) {
        try {
            String query = "INSERT INTO sys.StudentInformation (FirstName, LastName, Email, DateOfBirth, Comments) "
                    + "VALUES ('"+firstName+"', '"+lastName+"', '"+email+"', '"+dateOfBirth+"', '"+comments+"')";
            Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "The record has been inserted.", "MESSAGE", JOptionPane.OK_OPTION);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteDbQuery(String firstName, String lastName, String email,
                               String dbUrl, String dbUser, String dbPassword) {
        try {
            String query = "DELETE FROM sys.StudentInformation WHERE "
                    + "FirstName = '"+firstName+"' "
                    + "AND LastName = '"+lastName+"' "
                    + "AND Email = '"+email+"'";
            Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "The record has been deleted.", "MESSAGE", JOptionPane.OK_OPTION);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static int checkRowDbQuery(String firstName, String lastName, String email, String dateOfBirth, String comments,
                                       String dbUrl, String dbUser, String dbPassword) {
        ArrayList studentListCount = new ArrayList<>();
        int count;
        try {
            Student student;
            Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FirstName, LastName, Email, DateOfBirth FROM sys.StudentInformation "
                    + "WHERE FirstName IN ('"+firstName+"') "
                    + "AND LastName IN ('"+lastName+"') "
                    + "AND Email IN ('"+email+"') "
                    + "AND DateOfBirth IN ('"+dateOfBirth+"') "
                    + "AND Comments IN ('"+comments+"')");
            while(resultSet.next()){
                student = new Student();
                firstName = resultSet.getString("FirstName");
                lastName = resultSet.getString("LastName");
                email = resultSet.getString("Email");
                dateOfBirth  = resultSet.getString("DateOfBirth");
                comments = resultSet.getString("Comments");
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setDateOfBirth(dateOfBirth);
                student.setComments(comments);
                studentListCount.add(student);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        count = studentListCount.size();
        return count;
    }

    private void writeToFile(ArrayList<Student> studentList) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            FileWriter writer;
            writer = new FileWriter(path);
            writer.write("Student List:" + "\r\n" + "\r\n");
            for(int i = 0; i < studentList.size(); i++) {
                writer.write(i + 1 + ". " + studentList.get(i).getFirstName().toString() + "\r\n" +
                        studentList.get(i).getLastName().toString() + "\r\n" +
                        studentList.get(i).getEmail().toString() + "\r\n" +
                        studentList.get(i).getDateOfBirth().toString() + "\r\n" +
                        studentList.get(i).getComments().toString() + "\r\n" + "\r\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Inserted data into text file", "MESSAGE", JOptionPane.OK_OPTION);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JTextField commentsTextField;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton firstButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel forwardSlashLabel1;
    private javax.swing.JLabel forwardSlashLabel2;
    private javax.swing.JButton lastButton;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel studentFormTitleLabel;
    private javax.swing.JTextField yearTextField;

}
