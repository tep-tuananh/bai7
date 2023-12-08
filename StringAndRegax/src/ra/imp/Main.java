package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class Main {
    Product[] arrProduct = new Product[100];
    int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        do {
            System.out.println("*************Menu****************");
            System.out.println("1.Nhập thông tin n sản phẩm: ");
            System.out.println("2 . Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp ác sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo thên sản phẩm");
            System.out.println("7. Nhập số lượng sản phẩm ");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái hoạt động");
            System.out.println("10. Thoát");
            System.out.println("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    main.inputInfor(scanner);
                    break;
                case 2:
                    main.outputInfor();
                    break;
                case 3:
                    main.tinhLoiNhuan();
                    System.out.println("Đã hoàn thành");
                    break;
                case 4:
                        main.sapXep();
                    System.out.println("Đã hoàn thành");
                    break;
                case 5:
                    main.thongke(scanner);
                    System.out.println("Đã hoàn thành");
                    break;
                case 6:
                    main.find(scanner);
                    System.out.println("Hoàn thành");
                    break;
                case 7:
                    main.sum(scanner);
                    System.out.println("Đã hoàn thành");
                    break;
                case 8:
                    main.tongSanLuongBanRa(scanner);
                    System.out.println("Đã Hoàn Thành");
                    break;
                case 9:
                    main.thaydoiStatus(scanner);
                    System.out.println("Đã hoàn thành");
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn tự 1-10");
            }
        } while (true);
    }

    public void inputInfor(Scanner scanner) {
        System.out.println("Nhập n sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (index < arrProduct.length) {
                arrProduct[index] = new Product();
                arrProduct[index].inputData(scanner, arrProduct, index);
                index++;
            }
        }
    }

    public void tinhLoiNhuan() {
        for(int i=0;i<index;i++)
        {
            arrProduct[i].mark();
        }
    }

    public void outputInfor() {
        for (int i = 0; i < index; i++) {
            arrProduct[i].display();

        }
    }
    // sắp xếp lợi nhuận giảm dần
    public void sapXep()
    {
        for(int i=0;i<index;i++)
        {
            arrProduct[i].sapXepLoiNhuan(arrProduct,index);
        }
    }
    public void thongke(Scanner scanner)
    {
        for(int i=0;i<index;i++)
        {
            arrProduct[i].thongKe(scanner,arrProduct,index);
        }
    }
    public void find(Scanner scanner)
    {
        for(int i=0;i<index;i++)
        {
            arrProduct[i].findProductName(scanner,arrProduct,index);
        }
    }
    public void sum(Scanner scanner)
    {
        for(int i=0;i<index;i++)
        {
            arrProduct[i].nhapSanPham(scanner,arrProduct,index);
        }
    }
    public  void tongSanLuongBanRa(Scanner scanner)
    {
        for(int i=0;i<index;i++)
        {
            arrProduct[i].banSanPham(scanner,arrProduct,index);
        }
    }
    public  void thaydoiStatus(Scanner scanner)
    {
        for(int i=0;i<index;i++)
        {
            arrProduct[i].thayDoiStatus(scanner,arrProduct,index);
        }
    }
}
