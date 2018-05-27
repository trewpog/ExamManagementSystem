/*
 * Created by JFormDesigner on Sat May 26 23:49:29 CEST 2018
 */

package al.edu.fti.ui.dashboard.adminPanels;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.Role;
import al.edu.fti.entity.StudentDetail;
import al.edu.fti.entity.User;
import al.edu.fti.enums.StatusEnum;
import al.edu.fti.service.IRoleService;
import al.edu.fti.service.IUserService;
import al.edu.fti.utils.StringGeneratorCode;
import org.jdesktop.swingx.HorizontalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ardit Azo
 */
public class CreateStudent extends JPanel {

    private IRoleService roleService = FtiApplication.roleService;
    private IUserService userService = FtiApplication.userService;

    public CreateStudent() {
        initComponents();
    }

    private void maleRBItemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            maleRBValue = true;
            femaleRBValue = false;

            femaleRB.setSelected(false);
        }
    }

    private void femaleRBItemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            femaleRBValue = true;
            maleRBValue = false;

            maleRB.setSelected(false);
        }
    }

    private void createNewStudentBtnActionPerformed(ActionEvent e) {

        Boolean createAction = true;

        String firstName = firstNameTF.getText().trim();
        String lastName = lastNameTF.getText().trim();
        String email = emailTF.getText().trim();
        String password = passwordTF.getText().trim();
        String status = statusCB.getSelectedItem().toString();

        Date dateBirth = null;
        if(!dateBirthTF.getText().trim().equals("")) {
            try {
                dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirthTF.getText().trim());
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }

        String phoneNumber = phoneNumberTF.getText().trim();
        String address = addressTF.getText().trim();
        String placeBirth = placeBirthTF.getText().trim();
        String fatherName = fatherNameTF.getText().trim();
        String motherName = motherNameTF.getText().trim();

        String errorMessage = "Plese fill up the fields: ";

        if(firstName.equals("")) {
            createAction = false;
            errorMessage += "First name ";
        }
        if(lastName.equals("")) {
            createAction = false;
            errorMessage += "Last name ";
        }
        if(email.equals("")) {
            createAction = false;
            errorMessage += "Email ";
        }
        if(password.equals("")) {
            createAction = false;
            errorMessage += "Password ";
        }
        if(status.equals("")) {
            createAction = false;
            errorMessage += "Status ";
        }

        if(createAction) {

            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setAmzaNumber(StringGeneratorCode.randomAlphaNumeric(5));
            studentDetail.setStudentCode(StringGeneratorCode.randomAlphaNumeric(10));
            studentDetail.setAddress(address);
            studentDetail.setPlaceBirthday(placeBirth);
            studentDetail.setEmail(email);
            studentDetail.setFatherName(fatherName);
            studentDetail.setMotherName(motherName);

            User userStudent = new User();
            userStudent.addStudentDetail(studentDetail);
            userStudent.setUsername(firstName.toLowerCase() + "." + lastName.toLowerCase());
            userStudent.setFirstName(firstName);
            userStudent.setLastName(lastName);
            userStudent.setEmail(email);
            userStudent.setPassword(password);
            String gender = maleRBValue ? "Male" : (femaleRBValue ? "Female" : "");
            userStudent.setGender(gender);
            userStudent.setStatus(StatusEnum.getStatus(status));
            userStudent.setDateBirthday(dateBirth);
            userStudent.setPhoneNumber(phoneNumber);
            userStudent.setDateUpdate(new Date());
            userStudent.setDateCreation(new Date());
            Role lecturerRole = roleService.getRoleById(3L);
            userStudent.setRole(lecturerRole);

            studentDetail.setUser(userStudent);

            userService.createStudent(userStudent);

        } else {
            errorMsgLbl.setText(errorMessage);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        headerLbl = new JLabel();
        firstNameLbl = new JLabel();
        firstNameTF = new JTextField();
        lastNameLbl = new JLabel();
        lastNameTF = new JTextField();
        emailLbl = new JLabel();
        emailTF = new JTextField();
        passwordLbl = new JLabel();
        passwordTF = new JTextField();
        genderLbl = new JLabel();
        panel1 = new JPanel();
        maleRB = new JRadioButton();
        femaleRB = new JRadioButton();
        statusLbl = new JLabel();
        statusCB = new JComboBox();
        dateBirthLbl = new JLabel();
        dateBirthTF = new JTextField();
        phoneNuberLbl = new JLabel();
        phoneNumberTF = new JTextField();
        addressLbl = new JLabel();
        addressTF = new JTextField();
        placeBirthLbl = new JLabel();
        placeBirthTF = new JTextField();
        fatherNameLbl = new JLabel();
        fatherNameTF = new JTextField();
        motherNameLbl = new JLabel();
        motherNameTF = new JTextField();
        errorMsgLbl = new JLabel();
        panel2 = new JPanel();
        cancelBtn = new JButton();
        saveBtn = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(480, 450));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {121, 288, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 30, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- headerLbl ----
        headerLbl.setText("Create New Student");
        headerLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        headerLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        add(headerLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- firstNameLbl ----
        firstNameLbl.setText("* First name");
        firstNameLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        firstNameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(firstNameLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(firstNameTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- lastNameLbl ----
        lastNameLbl.setText("* Last name");
        lastNameLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        lastNameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(lastNameLbl, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(lastNameTF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- emailLbl ----
        emailLbl.setText("* Email");
        emailLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        emailLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(emailLbl, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(emailTF, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- passwordLbl ----
        passwordLbl.setText("* Password");
        passwordLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        passwordLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(passwordLbl, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(passwordTF, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- genderLbl ----
        genderLbl.setText("Gender");
        genderLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        genderLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(genderLbl, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== panel1 ========
        {
            panel1.setLayout(new HorizontalLayout());

            //---- maleRB ----
            maleRB.setText("Male");
            maleRB.addItemListener(e -> maleRBItemStateChanged(e));
            panel1.add(maleRB);

            //---- femaleRB ----
            femaleRB.setText("Female");
            femaleRB.addItemListener(e -> femaleRBItemStateChanged(e));
            panel1.add(femaleRB);
        }
        add(panel1, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- statusLbl ----
        statusLbl.setText("* Status");
        statusLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        statusLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(statusLbl, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(statusCB, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- dateBirthLbl ----
        dateBirthLbl.setText("Date of birth");
        dateBirthLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        dateBirthLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(dateBirthLbl, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- dateBirthTF ----
        dateBirthTF.setToolTipText("format: dd/mm/yyyy");
        add(dateBirthTF, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- phoneNuberLbl ----
        phoneNuberLbl.setText("Phone number");
        phoneNuberLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        phoneNuberLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(phoneNuberLbl, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(phoneNumberTF, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- addressLbl ----
        addressLbl.setText("Address");
        addressLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        addressLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(addressLbl, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(addressTF, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- placeBirthLbl ----
        placeBirthLbl.setText("Place of birth");
        placeBirthLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        placeBirthLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(placeBirthLbl, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(placeBirthTF, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- fatherNameLbl ----
        fatherNameLbl.setText("Father name");
        add(fatherNameLbl, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 5, 5), 0, 0));
        add(fatherNameTF, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- motherNameLbl ----
        motherNameLbl.setText("Mother name");
        add(motherNameLbl, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 5, 5), 0, 0));
        add(motherNameTF, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- errorMsgLbl ----
        errorMsgLbl.setForeground(Color.red);
        errorMsgLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        add(errorMsgLbl, new GridBagConstraints(0, 13, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 103, 63, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- cancelBtn ----
            cancelBtn.setText("Cancel");
            panel2.add(cancelBtn, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel2, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- saveBtn ----
        saveBtn.setText("Save");
        saveBtn.addActionListener(e -> createNewStudentBtnActionPerformed(e));
        add(saveBtn, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My components
        statusCB.addItem(StatusEnum.ACTIVE.toString());
        statusCB.addItem(StatusEnum.DISABLED.toString());
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JLabel headerLbl;
    private JLabel firstNameLbl;
    private JTextField firstNameTF;
    private JLabel lastNameLbl;
    private JTextField lastNameTF;
    private JLabel emailLbl;
    private JTextField emailTF;
    private JLabel passwordLbl;
    private JTextField passwordTF;
    private JLabel genderLbl;
    private JPanel panel1;
    private JRadioButton maleRB;
    private JRadioButton femaleRB;
    private JLabel statusLbl;
    private JComboBox statusCB;
    private JLabel dateBirthLbl;
    private JTextField dateBirthTF;
    private JLabel phoneNuberLbl;
    private JTextField phoneNumberTF;
    private JLabel addressLbl;
    private JTextField addressTF;
    private JLabel placeBirthLbl;
    private JTextField placeBirthTF;
    private JLabel fatherNameLbl;
    private JTextField fatherNameTF;
    private JLabel motherNameLbl;
    private JTextField motherNameTF;
    private JLabel errorMsgLbl;
    private JPanel panel2;
    private JButton cancelBtn;
    private JButton saveBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //  My components
    Boolean maleRBValue = false;
    Boolean femaleRBValue = false;
}