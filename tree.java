import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class tree {       //deklarasi class tubes

    static Scanner in = new Scanner(System.in);//deklarasi perintah inputan
    public void insert(node a, int b){          //deklarasi fungsi insert
        if(b<a.value){             //  
            if(a.left!=null){  //
                insert(a.left,b); // 
            }else{
                a.left=new node();
                a.left.input(b);
            }
        }else if(b>a.value){
            if(a.right!=null){
                insert(a.right,b);
            }else{
                a.right=new node();
                a.right.input(b);
            }
        }
    }

    public void view(node a){   //menampilkan node a(harga) secara inOrder
        System.out.println("In Order:");
        inOrder(a);
        System.out.println(" ");
    }
    public void inOrder(node a){
        if(a!=null){
            inOrder(a.left);
            System.out.println(a.value+" ");
            inOrder(a.right);
        }
    }
   
}

class node{ //deklarasi class node
    node left,right; 
    int value;
    public void input(int a){ //deklarasi fungsi input
        value=a;
    }

    public static void main(String[] args) { 
        //int n=10, m=10;
        int x=0,y=0,z=0; 
        int jumsuper=300, jumbiasa=300;//stok awal telur biasa dan telur super 300 butir
        int jumsuper1=300, jumbiasa1=300;
        int []pesanantelur = new int[50];
        String []jenisTelur = new String[50];
        tree tr=new tree();
        node root=new node();
        int a;
        int r=1;

        Queue<String> pembeli = new LinkedList<>();//deklarasi queue dengan linkedlist
        Stack<Integer> telur1 = new Stack<>();//create stack untuk telur biasa
        Stack<Integer> telur2 = new Stack<>();//create stack untuk telur super
        Scanner pilih = new Scanner(System.in);//deklarasi perintah inputan
        Scanner string = new Scanner(System.in);
        int finish=-1;
        //int telurBiasa, telurSuper;
        int hbiasa=2000, hsuper=2500;//deklarasi harga telur biasa dan super

        for(int i=1; i<=10; i++) {//perulangan 10 karpet untuk masing2 telur
            telur1.add(30);//sekarpet telur biasa = 30 butir
            telur2.add(30);//sekarpet telur super = 30 butir
        }
        // System.out.println("Stok telur biasa:"+telur1);
        // System.out.println("Stok telur super:"+telur2);

        do {
            System.out.println("*****************************************");
            System.out.println("*        PROGRAM KEDAI TELUR K1         *");
            System.out.println("*                                       *");
            System.out.println("*****************************************");
            System.out.println("* Silahkan pilih diantara menu berikut: *");
            System.out.println("*                                       *");
            System.out.println("*  1. Pesan Telur                       *");
            System.out.println("*  2. Panggil Pemesan                   *");
            System.out.println("*  3. Cek Persediaan Telur              *");
            System.out.println("*  4. Daftar Antrian                    *");
            System.out.println("*  5. Tambah Persediaan                 *");
            System.out.println("*  6. Riwayat Transaksi (Ascending)     *");
            System.out.println("*  7. Keluar Program                    *");
            System.out.println("*****************************************");
            System.out.print  ("Pilih menu: ");
            int menu = pilih.nextInt();//input pilihan menu

            switch(menu) {
                case 1:
                System.out.println("=========================================");
                System.out.println("----------------Pesan Telur--------------");
                System.out.println("--Silahkan Inputkan:                   --");
                System.out.print  ("Nama :");
                String nama = string.nextLine();//input nama pembeli


                System.out.println("--Silahkan pilih jenis telur           --");
                System.out.println("--1. Telur Biasa (Rp. 2000/butir)      --");
                System.out.println("--2. Telur Super (Rp. 2500/butir)      --");
                System.out.print  ("Pilih: ");
                int pilihan = pilih.nextInt();//input pilihan jenis telur yang dibeli

                if (pilihan==1) {
                    System.out.println("Inputkan jumlah telur yang akan dibeli");
                    System.out.print("Jumlah(butir): ");
                    int beli = pilih.nextInt();//input jumlah butir telur biasa/super yang dibeli
                    int bayar;//inisialisasi bayar dengan tipe data integer
                    if(beli<jumbiasa){
                        pesanantelur[x] = beli;
                        jenisTelur[y] ="telur biasa";
                        jumbiasa=jumbiasa-beli;
                        x++; y++;
                        a=beli*hbiasa;//total harga telur seteleh dikali dengan jumlah
                        if(r==1){//jika r = 1
                            root.input(a);//a akan menjadi root
                            r++;    
                        }else{
                            tr.insert(root, a);//a akan menjadi node di bawahnya
                        }
                        System.out.println("");
                            System.out.println("=========================================");
                            System.out.println("=           KEDAI TELUR SDAK1           =");
                            System.out.println("=========================================");
                            System.out.println("=                                       =");                      
                            System.out.println("=Nama : "+nama+"                        =");
                            System.out.println("=Pesanan :"+beli+" Butir Telur Biasa    =");   
                            System.out.println("=Total harga :Rp."+a+"                  =");
                            System.out.println("=Silahkan lakukan pembayaran            =");
                            System.out.println("=========================================");
                        }else{
                            System.out.println("=========================================");
                            System.out.println("=   Maaf, Persediaan telur tidak cukup  =");
                            System.out.println("=         Harap isi ulang stok          =");
                            System.out.println("=========================================");
                            break;
                        }

                        do{
                        System.out.print  ("Bayar: ");
                            bayar = pilih.nextInt();//input jumlah uang
                            if(bayar<beli*hbiasa)//jika uang yang dibayarkan < total harga telur biasa
                                System.out.println("=  Maaf, uang yang anda inputkan kurang =");    
                        }while(bayar<beli*hbiasa);
                        System.out.print("Kembalian :Rp. "+(bayar-beli*hbiasa));
                        pembeli.add(nama);//add nama pembeli ke daftar antrian
                        System.out.println("");
                        System.out.println("=========================================");
                  
                    }else if(pilihan==2 && pilihan<jumsuper){
                        System.out.println("Inputkan jumlah telur yang akan dibeli");
                        System.out.print("Jumlah(butir): ");
                        int beli = pilih.nextInt();//input jumlah telur yang akan dibeli
                        if(beli<jumbiasa){
                            pesanantelur[x]=beli;
                            jenisTelur[y]="telur super";
                            jumsuper=jumsuper-beli;
                            x++; y++;
                            a=beli*hsuper;
                            if(r==1){//jika r = 1
                                root.input(a);//a akan menjadi root
                                r++;    
                            }else{
                                tr.insert(root, a);//a akan menjadi node dibawahnya
                            }
                            System.out.println("");
                            System.out.println("=========================================");
                            System.out.println("=           KEDAI TELUR SDAK1           =");
                            System.out.println("=========================================");
                            System.out.println("=                                       =");                      
                            System.out.println("=Nama : "+nama+"                        =");
                            System.out.println("=Pesanan :"+beli+" Butir Telur Biasa    =");   
                            System.out.println("=Total harga :Rp."+a+"                  =");
                            System.out.println("=Silahkan lakukan pembayaran            =");
                            System.out.println("=========================================");
                        }else{
                            System.out.println("=========================================");
                            System.out.println("=   Maaf, Persediaan telur tidak cukup  =");
                            System.out.println("=         Harap isi ulang stok          =");
                            System.out.println("=========================================");
                            break;
                        }
                        int bayar;//inisialisasi bayar dengan tipe data integer
                        do{
                            System.out.print("Bayar: ");
                            bayar = pilih.nextInt();//input jumlah uang yang dibayarkan
                            if(bayar<beli*hsuper)//jika uang yang dibayarkan < dari total harga telur super
                                System.out.println("Maaf, uang yang anda inputkan kurang");    
                        }while(bayar<beli*hsuper);
                        System.out.print("Kembalian :Rp. "+(bayar-beli*hsuper));
                        pembeli.add(nama);//add nama pelanggan ke antrian
                        System.out.println("");
                    }else{
                        System.out.println("Maaf, pilihan tidak tersedia");
                    }
                    break;
                
                case 2:
                    System.out.println("Pesanan atas nama:"+pembeli.peek());//memanggil nama paling awal yang melakukan transaksi
                    pembeli.poll();//membuang nama pembeli setelah dipanggil
                    System.out.println("Jumlah pesanan:");
                    System.out.println(pesanantelur[z]+" Butir Telur");
                    if(jenisTelur[z]=="telur biasa"){ //jenis telur --> telur biasa
                        int b = telur1.size()-1;//inisialisasi integer b = size telur biasa dikurang 1 (indeks)
                        int ambil=pesanantelur[z];//inisialisasi integer ambil = pesanan telur  yang dipesan pelanggan
                        jumbiasa1=jumbiasa1-pesanantelur[z];//jumlah stok dikurang dengan pesanan telur
                        if(ambil<(telur1.get(b))){//yang dipesan lebih kecil dari nilai stack teratas
                            telur1.set(b, (telur1.get(b))-ambil); //akan disisipkan nilai dari, indeks terbesar - jumlah yang dipesan 
                        }else if(ambil==(telur1.get(b))){//yang dipesan sama dengan nilai dari indeks terbesar 
                            telur1.pop();//menghapus elemen teratas stack 
                        }else{ 
                            while(ambil>(telur1.get(b))){ //yang dipesan lebih besar dari nilai indeks terbesar 
                                ambil=ambil-telur1.get(b); //pesanan telur - nilai dari indeks terbesar 
                                telur1.pop(); //menghapus elemen teratas stack 
                                b--; //pengurangan indeks 
                            }
                            telur1.set(b, (telur1.get(b))-ambil); //akan disisipkan nilai dr hasil pengurangan indeks terbesar-jumlah yang dipesan 
                        }

                    } else if(jenisTelur[z]=="telur super"){ //jenis telur --> telur super 
                        int b = telur2.size()-1;//inisialisasi integer b = size telur super dikurang 1 (indeks)
                        int ambil=pesanantelur[z];//inisialisasi integer ambil = pesanan telur super yang dipesan pelanggan
                        if(ambil<(telur2.get(b))){//yang dipesan lebih kecil dari nilai stack teratas
                            telur2.set(b, (telur2.get(b))-ambil);//akan disisipkan nilai dari, indeks terbesar - jumlah yang dipesan 
                        }else if(ambil==(telur2.get(b))){//yang dipesan sama dengan nilai dari indeks terbesar 
                            telur2.pop();//menghapus elemen teratas stack 
                        }else{
                            while(ambil>(telur2.get(b))){ //yang dipesan lebih besar dari nilai indeks terbesar 
                                ambil=ambil-telur2.get(b); //pesanan telur - nilai dari indeks terbesar 
                                telur2.pop(); //menghapus elemen teratas stack 
                                b--; //pengurangan indeks 
                            }
                            telur2.set(b, (telur2.get(b))-ambil);  //akan disisipkan nilai dr hasil pengurangan indeks terbesar - jumlah yang dipesan 
                        
                        }
                        jumsuper1=jumsuper1-pesanantelur[z]; //
                    }
                    z++; //z bertambah satu 
                    break;
                
                case 3:
                    System.out.println("=========================================");
                    System.out.println("Stok telur biasa: "+telur1);
                    System.out.println("Stok telur biasa: "+jumbiasa1);
                    System.out.println("Stok telur super: "+telur2);
                    System.out.println("Stok telur super: "+jumsuper1);
                    System.out.println("=========================================");
                    break;

                case 4:
                    System.out.println("=========================================");
                    System.out.println("Daftar antrian :"+pembeli);
                    System.out.println("=========================================");
                    pilih.next();
                    break;

                case 5:
                    System.out.println("=========================================");
                    System.out.println("= Pilih jenis telur yang akan diisi:    =");
                    System.out.println("= 1. Telur Biasa                        =");
                    System.out.println("= 2. Telur Super                        =");
                    int stok = pilih.nextInt();
                    if(stok==1){//jika dipilih telur biasa 
                        System.out.println("Jumlah(karpet): ");
                        int tambah = pilih.nextInt();
                        if(tambah>0){
                            for(int i=0;i<tambah;i++){
                                telur1.add(30);
                            }
                            jumbiasa=jumbiasa+30*tambah;
                            jumbiasa1=jumbiasa1+30*tambah;
                            
                        }else {
                            System.out.println("Nilai tidak valid");
                        }
                        System.out.println("=========================================");
                    } else if(stok==2){
                        System.out.println("Jumlah(karpet): ");
                        int tambah = pilih.nextInt();
                        if(tambah>0){
                            for(int i=0;i<tambah;i++){
                                telur2.add(30);
                            }
                        }else {
                            System.out.println("Nilai tidak valid");
                        }
                        System.out.println("=========================================");
                        jumsuper=jumsuper+30*tambah;
                        jumsuper1=jumsuper1+30*tambah;
                    } else {
                        System.out.println("=========================================");
                        System.out.println("=     Maaf, Pilihan tidak tersedia      =");
                        System.out.println("=========================================");
                    }
                    break;
                    
                    
                    case 6:
                        tr.view(root);//menampilkan urutan yang terkecil dari riwayat transaksi
                        break;

                    case 7:
                        finish++;
                        break;
                    
                    default:
                        System.out.println("=========================================");
                        System.out.println("=     Maaf, Pilihan Tidak Tersedia      =");
                        System.out.println("=========================================");
            }

 

        } while(finish==-1);
        System.out.println("=========================================");
        System.out.println("==============TERIMA KASIH===============");
        System.out.println("=========================================");
        
    

    }

}
