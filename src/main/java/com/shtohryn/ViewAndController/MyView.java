package com.shtohryn.ViewAndController;

import com.shtohryn.model.entity.CurlerModel;
import com.shtohryn.model.entity.PackageModel;
import com.shtohryn.model.entity.UnitModel;
import com.shtohryn.model.entity.UserAccountModel;
import com.shtohryn.model.metadata.TableMetaData;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.service.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner scanner = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("-t", " ");
        menu.put("-s", " ");

        menu.put("1", "   1 - Table: Dish");
        menu.put("11", "  11 - Create for Package");
        menu.put("12", "  12 - Update Package");
        menu.put("13", "  13 - Delete from Package");
        menu.put("14", "  14 - Select Package");
        menu.put("15", "  15 - Find Package by ID");

        menu.put("2", "   2 - Table: User_Account");
        menu.put("21", "  21 - Create for User_Account");
        menu.put("22", "  22 - Update User_Account");
        menu.put("23", "  23 - Delete from User_Account");
        menu.put("24", "  24 - Select User_Account");
        menu.put("25", "  25 - Find User_Account by ID");

        menu.put("3", "   3 - Table: Unit");
        menu.put("31", "  31 - Create for Unit");
        menu.put("32", "  32 - Update Unit");
        menu.put("33", "  33 - Delete from Unit");
        menu.put("34", "  34 - Select Unit");
        menu.put("35", "  35 - Find Unit by ID");

        menu.put("4", "   4 - Table: Curler");
        menu.put("41", "  41 - Create for Curler");
        menu.put("42", "  42 - Update Curler");
        menu.put("43", "  43 - Delete from Curler");
        menu.put("44", "  44 - Select Curler");
        menu.put("45", "  45 - Find Curler by ID");
/****************************************************************************/
        methodsMenu.put("-t", this::selectAllTables);
        methodsMenu.put("-s", this::takeStructureOfDB);

        methodsMenu.put("11", this::createForPackage);
        methodsMenu.put("12", this::updatePackage);
        methodsMenu.put("13", this::deleteFromPackage);
        methodsMenu.put("14", this::selectPackage);
        methodsMenu.put("15", this::findPackageByID);


        methodsMenu.put("21", this::createUserAccount);
        methodsMenu.put("22", this::updateUserAccount);
        methodsMenu.put("23", this::deleteUserAccount);
        methodsMenu.put("24", this::selectUserAccount);
        methodsMenu.put("25", this::findUserAccountById);


        methodsMenu.put("31", this::createForUnit);
        methodsMenu.put("32", this::updateUnit);
        methodsMenu.put("33", this::deleteFromUnit);
        methodsMenu.put("34", this::selectUnit);
        methodsMenu.put("35", this::findUnitByID);

        methodsMenu.put("41", this::createForDCurler);
        methodsMenu.put("42", this::updateCurler);
        methodsMenu.put("43", this::deleteFromCurler);
        methodsMenu.put("44", this::selectCurler);
        methodsMenu.put("45", this::deleteFromCurlerMoveUserAccount);

    }

    private void selectAllTables() throws SQLException {
        selectUserAccount();
        selectCurler();
        selectPackage();
        selectUnit();
    }

    private void takeStructureOfDB() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MetaDataService metaDataService = new MetaDataService();
        List<TableMetaData> tables = metaDataService.getTablesStructure();
        System.out.println("TABLE OF DATABASE: " + connection.getCatalog());
        for (TableMetaData table : tables) {
            System.out.println(table);
        }
    }

    //--------------------------------------------------------------
    private void deleteFromPackage() throws SQLException {
        System.out.println("Input ID(package_name) for Package:\n>");
        String id = scanner.nextLine();
        PackageService departmentService = new PackageService();
        int count = departmentService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForPackage() throws SQLException {
        System.out.println("Input ID(package_name) for Package:\n>");
        String package_name = scanner.nextLine();
        System.out.println("Input price for Package:\n>");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.println("Input packageNumber for Package:\n>");
        Integer packageNumber = scanner.nextInt();
        PackageModel entity = new PackageModel(package_name, price, packageNumber);
        PackageService packageService = new PackageService();
        int count = packageService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updatePackage() throws SQLException {
        System.out.println("Input ID(package_name) for Package:\n>");
        String package_name = scanner.nextLine();
        System.out.println("Input price for Package:\n>");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.println("Input packageNumber for Package:\n>");
        Integer packageNumber = scanner.nextInt();
        PackageModel entity = new PackageModel(package_name, price, packageNumber);
        PackageService packageService = new PackageService();
        int count = packageService.update(entity);
        System.out.printf("There are update %d rows\n", count);
    }

    private void selectPackage() throws SQLException {
        System.out.println("\nTable: Package");
        PackageService packageService = new PackageService();
        List<PackageModel> dish = packageService.findAll();
        for (PackageModel entity : dish) {
            System.out.println(entity);
        }
    }

    private void findPackageByID() throws SQLException {
        System.out.println("Input ID(package_name) for Package:\n>");
        String packageName = scanner.nextLine();
        PackageService packageService = new PackageService();
        PackageModel id = packageService.findById(packageName);
        System.out.println(id);
    }

    //-------------------------------------------------------
    public void createUserAccount() throws SQLException {
        System.out.println("Input ID(id_account) for User account:\n>");
    }

    public void updateUserAccount() throws SQLException {
        System.out.println("Input ID(id_account) for User account:\n>");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input ordertime for Custumer_table:\n>");
        Time ordertime = Time.valueOf(scanner.nextLine());
        System.out.println("Input id_waiter for Custmer_table:\n>");
        Integer curlerId = scanner.nextInt();
        UserAccountModel entity = new UserAccountModel(id, ordertime, curlerId);
        UserAccountService tableService = new UserAccountService();
        int count = tableService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    public void deleteUserAccount() throws SQLException {
        System.out.println("Input ID(id_account) for User account:\n>");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        UserAccountService accountService = new UserAccountService();
        int count = accountService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void selectUserAccount() throws SQLException {
        System.out.println("\nTable: Custumer_table");
        UserAccountService tableService = new UserAccountService();
        List<UserAccountModel> tables = tableService.findAll();
        for (UserAccountModel entity : tables) {
            System.out.println(entity);
        }
    }

    public void findUserAccountById() throws SQLException {
        System.out.println("Input ID(id_account) for User account:\n>");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        UserAccountService accountService = new UserAccountService();
        UserAccountModel account = accountService.findById(id);
        System.out.println(account);
    }
    //------------------------------------------------------------------------

    private void updateUnit() throws SQLException {
        System.out.println("Input ID(prod_name) for Product:\n>");
        String id = scanner.nextLine();
        UnitModel entity = new UnitModel(id);
        UnitService unitService = new UnitService();
        int count = unitService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromUnit() throws SQLException {
        System.out.println("Input ID(prod_name) for Product:\n>");
        String id = scanner.nextLine();
        UnitService unitService = new UnitService();
        int count = unitService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForUnit() throws SQLException {
        System.out.println("Input ID(prod_name) for Product:\n>");
        String id = scanner.nextLine();
        UnitModel entity = new UnitModel(id);
        UnitService unitService = new UnitService();
        int count = unitService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void selectUnit() throws SQLException {
        System.out.println("\nTable: Product");
        UnitService unitService = new UnitService();
        List<UnitModel> products = unitService.findAll();
        for (UnitModel entity : products) {
            System.out.println(entity);
        }
    }

    private void findUnitByID() throws SQLException {
        System.out.println("Input ID(prod_name) for Product:\n>");
        String id = scanner.nextLine();
        UnitService unitService = new UnitService();
        UnitModel unit = unitService.findById(id);
        System.out.println(unit);
    }


    //------------------------------------------------------------------------

    private void deleteFromCurler() throws SQLException {
        System.out.println("Input ID(id_waiter) for Waiter:\n>");
        Integer id = scanner.nextInt();
        CurlerService curlerService = new CurlerService();
        int count = curlerService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForDCurler() throws SQLException {
        System.out.println("Input ID(id_Curler) for Curler:\n>");
        Integer id = scanner.nextInt();
        System.out.println("Input name for Curler:\n>");
        String name = scanner.nextLine();
        System.out.println("Input lastname for Curler:\n>");
        String lastName = scanner.nextLine();
        CurlerModel entity = new CurlerModel(id, name, lastName);
        CurlerService curlerService = new CurlerService();
        int count = curlerService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCurler() throws SQLException {
        System.out.println("Input ID(id_Curler) for Curler:\n>");
        Integer id = scanner.nextInt();
        System.out.println("Input name for Curler:\n>");
        String name = scanner.nextLine();
        System.out.println("Input lastname for Curler:\n>");
        String lastName = scanner.nextLine();
        CurlerModel entity = new CurlerModel(id, name, lastName);
        CurlerService curlerService = new CurlerService();
        int count = curlerService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectCurler() throws SQLException {
        System.out.println("\nTable: Curler");
        CurlerService curlerService = new CurlerService();
        List<CurlerModel> waiters = curlerService.findAll();
        for (CurlerModel entity : waiters) {
            System.out.println(entity);
        }
    }

    private void findCurlerByID() throws SQLException {
        System.out.println("Input ID(id_curler) for Curler:\n>");
        Integer id = scanner.nextInt();
        CurlerService curlerService = new CurlerService();
        CurlerModel curlerModel = curlerService.findById(id);
        System.out.println(curlerModel);
    }

    private void deleteFromCurlerMoveUserAccount() throws SQLException {
        System.out.println("Input ID(id_curler) for Curler: ");
        Integer idDeleted = scanner.nextInt();
        System.out.println("Input ID(id_curler) for another Curler (for move custumer_tables):");
        Integer idMoveTo = scanner.nextInt();
        CurlerService curlerService = new CurlerService();
        int count = curlerService.deleteWithMoveOfCustumerTable(idDeleted, idMoveTo);
        System.out.printf("There are deleted %d rows\n", count);
    }
//-------------------------------------------------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = scanner.nextLine().toUpperCase();
            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = scanner.nextLine().toUpperCase();
            }
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("q"));
    }
}
