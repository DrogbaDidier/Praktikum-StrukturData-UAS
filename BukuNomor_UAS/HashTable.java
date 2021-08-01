package BukuNomor_UAS;

import javax.swing.JOptionPane;

public class HashTable {

    private DataTelephone[] hashArrayTelephone;
    private DataHandphone[] hashArrayHandphone;
    private int SizeTelephone;
    private int SizeHandphone;
    private int NOTelephone;
    private int NOHandphone;
    private int nElemenTelephone;
    private int nElemenHandphone;

    public HashTable(int SizeTelephone, int SizeHandphone) {
        this.SizeTelephone = SizeTelephone;
        this.SizeHandphone = SizeHandphone;
        nElemenTelephone = 0;
        nElemenHandphone = 0;
        NOTelephone = 0;
        NOHandphone = 0;
        hashArrayTelephone = new DataTelephone[SizeTelephone];
        hashArrayHandphone = new DataHandphone[SizeHandphone];
    }

    public void displayTable() {
        System.out.println("+---------------------------------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tData Nomor Telepon/Handphone Yang Telah Dimasukkan\t\t\t\t|");
        System.out.println("+---------------+---------------------------------------+-+---------------+-------------------------------------+");
        System.out.println("|  No\t\t|  Nomor Telepon Rumah\t\t\t| | No\t\t  |  Nomor Handphone\t\t\t|");
        System.out.println("+---------------+---------------------------------------+-+---------------+-------------------------------------+");
        int nilai;
        if (SizeTelephone > SizeHandphone) {
            nilai = SizeTelephone;
        } else {
            nilai = SizeHandphone;
        }

        for (int i = 0; i < nilai; i++) {

            if (i >= SizeTelephone) {
                System.out.print("| " + "xx" + "\t\t|  xx \t xx \t\t");
            } else {
                if (hashArrayTelephone[i] != null) {
                    System.out.print("| " + i + "\t\t|  " + hashArrayTelephone[i].getNO() + "\t" + hashArrayTelephone[i].getNomor() + "\t");
                } else {
                    System.out.print("| " + i + "\t\t|  -- \t-- \t\t");
                }
            }

            if (i >= SizeHandphone) {
                System.out.println("\t\t| | " + "xx" + "\t\t  | xx \t xx \t\t\t\t|");
            } else {
                if (hashArrayHandphone[i] != null) {
                    System.out.println("\t\t| | " + i + "\t\t  | " + hashArrayHandphone[i].getNO() + "\t" + hashArrayHandphone[i].getNomor() + " \t\t\t|");
                } else {
                    System.out.println("\t\t| | " + i + "\t\t  | -- \t-- \t\t\t\t|");
                }
            }
        }

        System.out.println("+---------------+---------------------------------------+-+---------------+-------------------------------------+");
        System.out.println("Jumlah Nomor Telepon Rumah = " + nElemenTelephone);
        System.out.println("Jumlah Nomor Handphone = " + nElemenHandphone);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    public int hashFunctionTelephone(int key) {
        return key % SizeTelephone;
    }

    public int hashFunctionHandphone(int key) {
        return key % SizeHandphone;
    }

    public void insertTelephone() {

        if (nElemenTelephone == SizeTelephone) {
            JOptionPane.showMessageDialog(null, "Maaf, Baris Pada Buku Telepon Penuh");
        } else {
            String Nomor = JOptionPane.showInputDialog(null, "Masukkan Nomor Telepon Rumah");
            DataTelephone item = new DataTelephone(NOTelephone, Nomor);
            NOTelephone++;
            int key = item.getNO();
            int hashVal = hashFunctionTelephone(key);
            while (hashArrayTelephone[hashVal] != null) {
                ++hashVal;
                hashVal %= SizeTelephone;
            }

            hashArrayTelephone[hashVal] = item;
            JOptionPane.showMessageDialog(null, "Nomor Telepon " + Nomor + " Berhasil Dimasukkan Ke Baris No " + hashVal);
            nElemenTelephone++;

        }

    }

    public void insertHandphone() {

        if (nElemenHandphone == SizeHandphone) {
            JOptionPane.showMessageDialog(null, "Maaf, Baris Pada Buku Telepon Penuh");
        } else {
            String Nomor = JOptionPane.showInputDialog(null, "Masukkan Nomor Handphone");
            DataHandphone item = new DataHandphone(NOHandphone, Nomor);
            NOHandphone++;
            int key = item.getNO();
            int hashVal = hashFunctionHandphone(key);
            while (hashArrayHandphone[hashVal] != null) {
                ++hashVal;
                hashVal %= SizeHandphone;
            }

            hashArrayHandphone[hashVal] = item;
            JOptionPane.showMessageDialog(null, "Nomor Telepon " + Nomor + " Berhasil Dimasukkan Ke Baris No " + hashVal);
            nElemenHandphone++;
        }

    }

    public DataTelephone deleteNOTelephone(int NO) {
        int hashVal = hashFunctionTelephone(NO);
        while (hashArrayTelephone[hashVal] != null) {
            if (hashArrayTelephone[hashVal].getNO() == NO) {
                DataTelephone temp = hashArrayTelephone[hashVal];
                String Nomor = hashArrayTelephone[hashVal].getNomor();
                JOptionPane.showMessageDialog(null, "Nomor Telepon " + Nomor + " Telah Dihapus");
                hashArrayTelephone[hashVal] = null;
                nElemenTelephone--;
                return temp;
            }
            ++hashVal;
            hashVal %= SizeTelephone;
        }
        JOptionPane.showMessageDialog(null, "No Telepon " + NO + " Tidak Tersedia");
        return null;

    }

    public DataTelephone deleteNomorTelephone(String Nomor) {
        for (int i = 0; i < SizeTelephone; i++) {
            if (hashArrayTelephone[i] != null) {
                if (hashArrayTelephone[i].getNomor().equals(Nomor)) {
                    hashArrayTelephone[i] = null;
                    nElemenTelephone--;
                    JOptionPane.showMessageDialog(null, "Nomor Telepon " + Nomor + " Telah Dihapus");
                    return hashArrayTelephone[i];

                }
            } else if (i == SizeTelephone - 1) {
                JOptionPane.showMessageDialog(null, "Nomor Telepon " + Nomor + " Tidak Tersedia");
                return null;
            }

        }
        return null;
    }

    public DataHandphone deleteNOHandphone(int NO) {
        int hashVal = hashFunctionHandphone(NO);
        while (hashArrayHandphone[hashVal] != null) {
            if (hashArrayHandphone[hashVal].getNO() == NO) {
                DataHandphone temp = hashArrayHandphone[hashVal];
                String Nomor = hashArrayHandphone[hashVal].getNomor();
                JOptionPane.showMessageDialog(null, "Nomor Handphone " + Nomor + " Telah Dihapus");
                hashArrayHandphone[hashVal] = null;
                nElemenHandphone--;
                return temp;
            }
            ++hashVal;
            hashVal %= SizeHandphone;
        }
        JOptionPane.showMessageDialog(null, "Nomor Handphone " + NO + " Tidak Tersedia");
        return null;
    }

    public DataHandphone deleteNomorHandphone(String Nomor) {
        for (int i = 0; i < SizeHandphone; i++) {
            if (hashArrayHandphone[i] != null) {
                if (hashArrayHandphone[i].getNomor().equals(Nomor)) {
                    hashArrayHandphone[i] = null;
                    nElemenHandphone--;
                    JOptionPane.showMessageDialog(null, "Nomor Handphone " + Nomor + " Telah Dihapus");
                    return hashArrayHandphone[i];

                }
            } else if (i == SizeHandphone - 1) {
                JOptionPane.showMessageDialog(null, "Nomor Handphone " + Nomor + " Tidak Tersedia");
                return null;
            }

        }
        return null;
    }

    public DataTelephone findNOTelephone(int NO) {

        int hashVal = hashFunctionTelephone(NO);
        while (hashArrayTelephone[hashVal] != null) {
            if (hashArrayTelephone[hashVal].getNO() == NO) {
                String Nomor = hashArrayTelephone[hashVal].getNomor();
                JOptionPane.showMessageDialog(null, "Nomor Telepon Rumah\nNo Baris : " + hashVal + "\nNo Baris : " + NO + "\nNo Telepon : " + Nomor);
                return hashArrayTelephone[hashVal];
            }
            ++hashVal;
            hashVal %= SizeTelephone;
        }
        JOptionPane.showMessageDialog(null, "Nomor Telepon " + NO + " Tidak Di Temuakan");
        return null;
    }

    public DataTelephone findNomorTelephone(String Nomor) {
        for (int i = 0; i < SizeTelephone; i++) {
            if (hashArrayTelephone[i] != null) {
                if (hashArrayTelephone[i].getNomor().equals(Nomor)) {
                    int NO = hashArrayTelephone[i].getNO();
                    JOptionPane.showMessageDialog(null, "Nomor Telepon Rumah\nNo Baris : " + i + "\nNo Baris : " + NO + "\nNo Telepon : " + Nomor);
                    return hashArrayTelephone[i];

                }
            } else if (i == SizeTelephone - 1) {
                JOptionPane.showMessageDialog(null, "Nomor Telepon Rumah " + Nomor + " Tidak Tersedia");
                return null;
            }

        }
        return null;
    }

    public DataHandphone findNOHandphone(int NO) {
        int hashVal = hashFunctionHandphone(NO);
        while (hashArrayHandphone[hashVal] != null) {
            if (hashArrayHandphone[hashVal].getNO() == NO) {
                String Nomor = hashArrayHandphone[hashVal].getNomor();
                JOptionPane.showMessageDialog(null, "Nomor Handphone\nNO Baris : " + hashVal + "\nNo Baris : " + NO + "\nNo Handphone : " + Nomor);
                return hashArrayHandphone[hashVal];
            }
            ++hashVal;
            hashVal %= SizeHandphone;
        }
        JOptionPane.showMessageDialog(null, "Nomor Handphone " + NO + " Tidak Di Temukan");
        return null;
    }

    public DataHandphone findNomorHandphone(String Nomor) {

        for (int i = 0; i < SizeHandphone; i++) {
            if (hashArrayHandphone[i] != null) {
                if (hashArrayHandphone[i].getNomor().equals(Nomor)) {
                    int NO = hashArrayHandphone[i].getNO();
                    JOptionPane.showMessageDialog(null, "Nomor Handphone\nNo Baris : " + i + "\nNo Baris : " + NO + "\nNO Handphone : " + Nomor);
                    return hashArrayHandphone[i];

                }
            } else if (i == SizeHandphone - 1) {
                JOptionPane.showMessageDialog(null, "Nomor Handphone " + Nomor + " Tidak Tersedia");
                return null;
            }

        }
        return null;
    }

    public DataTelephone updateTelephone(int NO) {

        int hashVal = hashFunctionTelephone(NO);
        while (hashArrayTelephone[hashVal] != null) {
            if (hashArrayTelephone[hashVal].getNO() == NO) {
                String input = JOptionPane.showInputDialog(null, "Masukkan Nomor Baru");
                DataTelephone item = new DataTelephone(NO, input);
                hashArrayTelephone[hashVal] = item;
                JOptionPane.showMessageDialog(null, "Data Berhasil di Perbarui");
                return hashArrayTelephone[hashVal];
            }
            ++hashVal;
            hashVal %= SizeTelephone;
        }
        JOptionPane.showMessageDialog(null, "Nomor Telepon " + NO + " Tidak Di Temuakan");
        return null;

    }

    public DataHandphone updateHandphone(int NO) {

        int hashVal = hashFunctionHandphone(NO);
        while (hashArrayHandphone[hashVal] != null) {
            if (hashArrayHandphone[hashVal].getNO() == NO) {
                String input = JOptionPane.showInputDialog(null, "Masukkan Nomor Baru");
                DataHandphone item = new DataHandphone(NO, input);
                hashArrayHandphone[hashVal] = item;
                JOptionPane.showMessageDialog(null, "Data Berhasil di Perbarui");
                return hashArrayHandphone[hashVal];
            }
            ++hashVal;
            hashVal %= SizeHandphone;
        }
        JOptionPane.showMessageDialog(null, "Nomor Handphone " + NO + " Tidak Di Temukan");
        return null;

    }
}
