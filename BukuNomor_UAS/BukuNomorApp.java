package BukuNomor_UAS;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class BukuNomorApp {

    public static void main(String[] args) {
//ImageIcon icon = new ImageIcon("");
        int jumlHandphone;
        int jumlTelephone;
        int NO;
        Scanner input;
        String inputan;
        boolean perulangan = true;
        HashTable BukuNomor;

        JOptionPane.showMessageDialog(null, "Selamat Datang Di Aplikasi Buku Telepon");
        inputan = JOptionPane.showInputDialog(null, "Masukkan Jumlah Nomor Telepon Yang Diinginkan");
        jumlTelephone = Integer.parseInt(inputan);
        inputan = JOptionPane.showInputDialog(null, "Masukkan Jumlah Nomor HP Yang Diinginkan");
        jumlHandphone = Integer.parseInt(inputan);

        BukuNomor = new HashTable(jumlTelephone, jumlHandphone);

        while (perulangan) {
            System.out.print("Masukkan aksi yang anda inginkan : Show = s, Insert = i, Delete = d, Find = f, Update = u, exit = e : ");
            input = new Scanner(System.in);
            inputan = input.nextLine();
            switch (inputan) {
                case "s":
                    BukuNomor.displayTable();
                    break;
                case "i":
                    inputan = JOptionPane.showInputDialog(null, "Pilih Jenis Alat Komunikasi :\n1. Telepon Rumah\n2. Handphone");
                    switch (inputan) {
                        case "1":
                            BukuNomor.insertTelephone();
                            break;
                        case "2":
                            BukuNomor.insertHandphone();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
                    }
                    break;
                case "d":
                    inputan = JOptionPane.showInputDialog(null, "Pilih Jenis Alat Komunikasi :\n1. Telepon Rumah\n2. Handphone");
                    switch (inputan) {
                        case "1":
                            inputan = JOptionPane.showInputDialog(null, "Menghapus Berdasarkan :\n1. Nomor Pada Baris\n2. NO Telepon Rumah");
                            switch (inputan) {
                                case "1":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Pada Baris");
                                    NO = Integer.parseInt(inputan);
                                    BukuNomor.deleteNOTelephone(NO);
                                    break;
                                case "2":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Telepon Rumah");
                                    BukuNomor.deleteNomorTelephone(inputan);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
                            }
                            break;
                        case "2":
                            inputan = JOptionPane.showInputDialog(null, "Menghapus Berdasarkan:\n1. Nomor Pada Baris\n2. Nomor Handphone :");
                            switch (inputan) {
                                case "1":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Pada Baris");
                                    NO = Integer.parseInt(inputan);
                                    BukuNomor.deleteNOHandphone(NO);
                                    break;
                                case "2":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Handphone");
                                    BukuNomor.deleteNomorHandphone(inputan);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");

                    }
                    break;
                case "f":
                    inputan = JOptionPane.showInputDialog(null, "Pilih Jenis Alat Komunikasi :\n1. Telepon Rumah\n2. Handphone");
                    switch (inputan) {
                        case "1":
                            inputan = JOptionPane.showInputDialog(null, "Mencari Berdasarkan :\n1. Nomor Pada Baris\n2. Nomor Telepon Rumah");
                            switch (inputan) {
                                case "1":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Pada Baris :");
                                    NO = Integer.parseInt(inputan);
                                    BukuNomor.findNOTelephone(NO);
                                    break;
                                case "2":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Telepon Rumah :");
                                    BukuNomor.findNomorTelephone(inputan);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
                            }
                            break;
                        case "2":
                            inputan = JOptionPane.showInputDialog(null, "Mencari Berdasarkan :\n1. Nomor Pada Baris\n2. Nomor Handphone");

                            switch (inputan) {
                                case "1":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Pada Baris :");
                                    NO = Integer.parseInt(inputan);
                                    BukuNomor.findNOHandphone(NO);
                                    break;
                                case "2":
                                    inputan = JOptionPane.showInputDialog(null, "Masukkan Nomor Handphone :");
                                    BukuNomor.findNomorHandphone(inputan);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
                    }
                    break;
                case "u":
                    inputan = JOptionPane.showInputDialog(null, "Pilih Jenis Alat Komunikasi :\n1. Telepon Rumah\n2. Handphone");
                    switch (inputan) {
                        case "1":
                            inputan = JOptionPane.showInputDialog(null, "Masukkan Baris Nomor Telepon Yang Ingin Diperbarui");
                            NO = Integer.parseInt(inputan);
                            BukuNomor.updateTelephone(NO);
                            break;

                        case "2":
                            inputan = JOptionPane.showInputDialog(null, "Masukkan Baris Nomor Handphone Yang Ingin Diperbarui");
                            NO = Integer.parseInt(inputan);
                            BukuNomor.updateHandphone(NO);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
                    }
                    break;
                case "e":
                    perulangan = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Aksi yang anda masukkan salah");
            }
        }

    }

}
