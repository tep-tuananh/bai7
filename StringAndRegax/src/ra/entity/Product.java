package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productID; // id
    private String productName;// tên
    private float inportPrice; // nhập vào giá  kho
    private float exportPrice; // giá xuất kho
    private float profit; // lợi nhuận
    private int quantity; // số sản phẩm
    private String description;// mô tả sản phẩm
    private boolean status; // mô tả trạng thái trỉ nhận giá trị true || false

    public Product() {
    }

    public Product(String productID, String productName, float inportPrice,
                   float exportPrice, float profit, int quantity,
                   String description, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.inportPrice = inportPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getInportPrice() {
        return inportPrice;
    }

    public void setInportPrice(float inportPrice) {
        this.inportPrice = inportPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int index) {
        this.productID = checkId(scanner, arrProduct, index);
        this.productName = checkName(scanner, arrProduct, index);
        this.inportPrice = checkinputPrice(scanner);
        //this.profit = loiNhuan(exportPrice, inportPrice);
        this.quantity = checkQuantity(scanner);
        System.out.println("Nhập vào mô tả: ");
        this.description = scanner.nextLine();
        this.status = checkStatus(scanner);
    }

    public void display() {
        System.out.println("Hiển thị thông tin ");
        System.out.println("Id: "+this.productID+" - tên sản phẩm:  "+this.productName);
        System.out.println("Giá trị nhập vào: "+this.inportPrice);
        System.out.println("Sô lượng: "+this.quantity);
        System.out.println("Mô tả: "+this.description);
        System.out.println("Mô tả trạng thái: "+((this.status==true)?"Đang bán":"Hết Hàng"));
    }

    public String checkId(Scanner scanner, Product[] arrProduct, int index) {
        System.out.println("Nhập vào mã sản phẩn: ");
        do {
            String productID = scanner.nextLine();
            String regex = "P[a-zA-Z0-9]{3}";
            boolean result = Pattern.matches(regex, productID);
            if (result == true) {
                boolean isExist = false;// chưa tồn tại
                for (int i = 0; i < index; i++) {
                    if (arrProduct[i].getProductID().equals(productID)) {
                        isExist = true;// đã chị trùng lặp
                        break;
                    }
                }
                if (isExist == true) {
                    System.err.println("Mã sản phẩm đã tồn tại,Nhập lại");
                } else {
                    return productID;
                }
            } else {
                System.err.println("Nhập sai định dạng mã sản  phẩm ");
            }
        } while (true);
    }

    public String checkName(Scanner scanner, Product[] arrProduct, int index) {
        {
            System.out.println("Nhập vào tên sản phẩm: ");
            do {
                String productName = scanner.nextLine();
                if (productName.length() >= 6 && productName.length() <= 50) {
                    boolean isExist = false;
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductName().equals(productName)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist == true) {
                        System.out.println("Tên mặt hàng đã tồn tại.Nhập lại");
                    } else {
                        return productName;
                    }
                } else {
                    System.err.println("Độ dài của tên từ 6 đến 50 kí tự");
                }
            } while (true);
        }

    }

    public float checkinputPrice(Scanner scanner) {
        System.out.println("Nhập vào giá nhập kho: ");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá trị nhập vào phải lớn hơn 0");
            }
        } while (true);
    }

    public float mark() {// Hàm tính loi nhuận
        float exportPrice = this.inportPrice +(this.inportPrice* 0.2F);
        return  exportPrice;
    }

    public float loiNhuan(float exportPrice, float inportPrice) {// phương thức tính lợi nhuận
        return this.profit=this.exportPrice - this.inportPrice;

    }

    public int checkQuantity(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm: ");
        do {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity > 0) {
                return quantity;
            } else {
                System.err.println("Nhập  số lượng sản phẩm lớn hơn 0 ");
            }
        } while (true);
    }

    public boolean checkStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái : ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Giá trị chỉ nhận true hoặc false");
            }
        } while (true);
    }
    public void sapXepLoiNhuan(Product [] products,int index){
        for(int i=1;i<index-1;i++)
        {
            for(int j=0;j<index;j++)
            {
                if(products[i].getProfit()<products[j].getProfit())
                {
                    float temp=products[i].getProfit();
                    products[i].setProfit(products[j].getProfit());
                    products[j].setProfit(temp);
                }
            }
        }
    }
    public void thongKe(Scanner scanner,Product [] product , int index)
    {
        System.out.println("Nhập sản phẩm muốn tìm: ");
        String nameProduct= scanner.nextLine();
        for(int i=0;i<index;i++)
        {
            if(product[i].getProductName().equals(nameProduct))
            {
                System.out.println(" giá sản phẩm: "+getProductName());
            }
            else
            {
                System.out.println("Không có sản phẩm đấy");
            }
        }
    }
    public void findProductName(Scanner scanner,Product [] product , int index)
    {
        System.out.println("Nhập vào tên sản phẩm cần tìm: ");
        String nameProduct=scanner.nextLine();
        for(int i=0;i<index;i++)
        {
            if(product[i].getProductName().equals(nameProduct))
            {
                System.out.println("Đã có sản phẩm này");
            }
            else
            {
                System.out.println("Không có sản phẩm này");
            }
        }
    }
    public  int  nhapSanPham(Scanner scanner,Product [] product , int index)
    {
        System.out.println("Nhập vào mã sản phẩm cần tìm: ");
        String ProductID=scanner.nextLine();
        for(int i=0;i<index;i++)
        {
            if(product[i].getProductID().equals(ProductID))
            {
                System.out.println("Nhập số lươợng sản phẩm: ");
                int n=Integer.parseInt(scanner.nextLine());
                this.quantity=getQuantity()+n;
                return quantity;
            }
            else
            {
                System.out.println("Không có mã này");
            }
        }
        return -1;
    }
    public  int  banSanPham(Scanner scanner,Product [] product , int index)
    {
        System.out.println("Nhập vào tên sản phẩm cần bán: ");
        String ProductName=scanner.nextLine();
        for(int i=0;i<index;i++)
        {
            if(product[i].getProductName().equals(ProductName))
            {
                System.out.println("Nhập số lươợng sản phẩm: ");
                int n=Integer.parseInt(scanner.nextLine());
                this.quantity=getQuantity()-n;
                return quantity;
            }
            else
            {
                System.out.println("Không có mã này");
            }
        }
        return -1;
    }
    public  boolean  thayDoiStatus(Scanner scanner,Product [] product , int index)
    {
        System.out.println("Nhập vào mã sản phẩm cần tìm: ");
        String ProductID=scanner.nextLine();
        for(int i=0;i<index;i++)
        {
            if(product[i].getProductID().equals(ProductID))
            {
                if(product[i].isStatus()==true)
                {
                    this.status=false;
                }
                else
                {
                    this.status=true;
                }
            }
            else
            {
                System.out.println("Không có mã này");
            }
        }
        return  this.status;
    }

}
