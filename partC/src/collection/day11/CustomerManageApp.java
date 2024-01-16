package collection.day11;

import java.util.ArrayList;
import java.util.List;

public class CustomerManageApp {
    private List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        CustomerManageApp app = new CustomerManageApp();
        app.start();
    }

    private void start() {
        initialize();

        // 메뉴 : 등록, 검색(이름, 그룹), 삭제, 수정, 전체 출력
        System.out.println("::::: 고객 관리 시스템 :::::");

        while (true) {
            System.out.println("\n1. 고객 등록\n2. 고객 검색\n3. 고객 삭제\n4. 고객 정보 수정\n5. 고객 리스트 출력\n0. 종료\n");
            System.out.print("메뉴 입력 >>> ");
            int menu = Integer.parseInt(System.console().readLine());

            switch (menu) {
                case 1:
                    System.out.println("== 고객 등록 ==");
                    registerCustomer();
                    break;
                case 2:
                    System.out.println("== 고객 검색 ==");
                    searchCustomer();
                    break;
                case 3:
                    System.out.println("== 고객 삭제 ==");
                    removeCustomer();
                    break;
                case 4:
                    System.out.println("== 고객 정보 수정");
                    modifyCustomer();
                    break;
                case 5:
                    System.out.println("== 고객 리스트 출력 ==");
                    printCustomer(this.customers, null);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("없는 메뉴입니다.");
                    break;
            }
        }
    }

    private List<Customer> filteredCustomersByName(String name) {
        List<Customer> temp = new ArrayList<>();
        for (Customer customer : this.customers) {
            if (customer.getName().equals(name)) {
                temp.add(customer);
            }
        }

        return temp;
    }

    private List<Customer> filteredCustomersByGroup(int group) {
        List<Customer> temp = new ArrayList<>();
        for (Customer customer : this.customers) {
            if (customer.getGroup() == group) {
                temp.add(customer);
            }
        }

        return temp;
    }

    private void registerCustomer() {
        System.out.println("@@@ 고객 등록을 시작합니다. @@@");
        System.out.print("고객 이름 (end: 종료) >>> ");
        String name = System.console().readLine();
        if (name.equals("end")) {
            return;
        }

        if (filteredCustomersByName(name).size() > 0) {
            System.out.print("이미 있는 고객입니다. 새로 등록하시겠습니까? (yes) ");
            String check = System.console().readLine();
            if (!check.equals("yes")) {
                return;
            }
        }

        System.out.print("전화번호 >>> ");
        String phone = System.console().readLine();

        System.out.print("그룹 (1: 일반, 2: VIP, 3: 기타) >>> ");
        int group = Integer.parseInt(System.console().readLine());

        customers.add(new Customer(name, phone, group));
    }

    private void searchCustomer() {
        System.out.println("@@@ 고객 검색을 시작합니다. @@@");
        System.out.print("검색할 기준 필드 입력 (이름, 그룹) >>> ");
        String field = System.console().readLine();
        if (field.equals("이름")) {
           while (true) {
                System.out.print("\n검색할 이름 입력 (end: 종료) >>> ");
                String name = System.console().readLine();
                if (name.equals("end")) {
                    break;
                }

                printCustomer(filteredCustomersByName(name), null);
           }
        } else if (field.equals("그룹")) {
            while (true) {
                System.out.print("\n검색할 그룹 입력 (1: 일반, 2: VIP, 3: 기타, 0: 종료) >>> ");
                int group = Integer.parseInt(System.console().readLine());
                if (group == 0) {
                    break;
                }

                printCustomer(filteredCustomersByGroup(group), null);
            }
        } else {
            System.out.println("검색할 수 없는 필드입니다.");
        }
    }

    private void removeCustomer() {
        System.out.println("@@@ 고객 삭제를 시작합니다. @@@");
        System.out.print("삭제할 고객 이름 입력 >>> (end: 종료)");
        String name = System.console().readLine();
        if (name.equals("end")) {
            return;
        }

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                System.out.println(customers.get(i).toString());
                System.out.print("정말로 삭제하시겠습니까? (yes) >>> ");
                String secondCheck = System.console().readLine();
                if (secondCheck.equals("yes")) {
                    customers.remove(i);
                    i--;
                }
            }
        }
    }

    private void modifyCustomer() {
        printCustomer(customers, "@@@ 고객 정보 수정 @@@ \n\n:: 고겍 리스트 목록 :: ");

        System.out.print("\n수정하고자 하는 고객의 이름 입력 (end: 종료) >>> ");
        String name = System.console().readLine();
        if (name.equals("end")) {
            return;
        }
        
        List<Customer> mod = filteredCustomersByName(name);
        for (Customer customer : mod) {
            System.out.println("-".repeat(20));
            System.out.print(customer.toString());
            System.out.println("-".repeat(20));
            System.out.print("변경할 전화 번호를 입력하시오 >>> ");
            String phone = System.console().readLine();
            System.out.print("변경할 그룹을 입력하시오 >>> ");
            int group = Integer.parseInt(System.console().readLine());

            System.out.print("정말로 수정하시겠습니까? (yes) >>> ");
            if (System.console().readLine().equals("yes")) {
                customer.modify(phone, group);
            }

        }
    }

    private void printCustomer(List<Customer> list, String titlString) {
        System.out.println((titlString == null) ? "@@@ 고객 리스트를 출력합니다. @@@" : titlString);
        System.out.println(String.format("%s", "=".repeat(20)));
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + ".  " + list.get(i).toString());
        }
    }

    private void initialize() {
        customers.add(new Customer("Kang", "010-1111-2222", 1));
        customers.add(new Customer("Yang", "010-2454-8891", 1));
        customers.add(new Customer("Kim", "012-4040-0009", 2));
        customers.add(new Customer("Lee", "02-827-4949", 3));
        customers.add(new Customer("Jin", "032-223-5988", 1));
        customers.add(new Customer("Yong", "1588-1588", 3));
    }
}
