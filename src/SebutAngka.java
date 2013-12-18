/*
 * Menyebutkan Angka ke rupiah dalam bahasa indonesia  
 * input  : 1500
 * output : Seribu lima ratus rupiah
 * */

public class SebutAngka implements ISebutAngka {
	
	private static final long ratusan = 100;
	private static final long ribuan = 1000;
	private static final long jutaan = 1000000;
	private static final long milyaran = 1000000000;
	private static String[] satuan;
	private static String[] puluhan;
	
	public SebutAngka()
	{
		 Initialize();
	}
	
	private void Initialize()
	{
		satuan = new String[]
				{
				"",
				"Satu",
				"Dua",
				"Tiga",
				"Empat",
				"Lima",
				"Enam",
				"Tujuh",
				"Delapan",
				"Sembilan",
				"Sepuluh",
				"Sebelas",
				"Dua belas",
				"Tiga belas",
				"Empat belas",
				"Lima belas",
				"Enam belas",
				"Tujuh belas",
				"Delapan belas",
				"Sembilan belas"
				};
		
		 puluhan = new String[]
				{
				"Sepuluh",
				"Dua puluh",
				"Tiga puluh",
				"Empat puluh",
				"Lima puluh",
				"Enam puluh",
				"Tujuh puluh",
				"Delapan puluh",
				"Sembilan puluh"
				};
	}
	
	public String Terbilang(long angka){
		StringBuilder sb = new StringBuilder();
		
		if(angka == 0)
			return sb.append("Nol").toString();
		
		//cek milyaran
		if(angka / milyaran > 0){
			sb.append(Terbilang(angka / milyaran));
			sb.append(" ");
			sb.append("Milyard");
			sb.append(" ");
			angka %= milyaran;
		}
		
		//cek jutaan
		if(angka / jutaan > 0){
			sb.append(Terbilang(angka / jutaan));
			sb.append(" ");
			sb.append("Juta");
			sb.append(" ");
			
			angka %= jutaan;
		}
		
		//cek ribuan
		if(angka / ribuan > 0){
			if((angka / ribuan) == 1){
				sb.append("Seribu");
				sb.append(" ");
			}
			else {
				sb.append(Terbilang(angka / ribuan));
				sb.append(" ");
				sb.append("Ribu");
				sb.append(" ");
			}
			
			angka %= ribuan;
		}
		
		//cek ratusan
		if(angka / ratusan > 0){
			
			if((angka / ratusan) == 1){
				sb.append("Seratus");
				sb.append(" ");
			}
			else{
				
				sb.append(Terbilang(angka / ratusan));
				sb.append(" ");
				sb.append("ratus");
				sb.append(" ");
			}
			
			angka %= 100;
			
		}
		
		if(angka > 0){
			  
			if(angka < 20){		
				sb.append(satuan[(int) angka]);
				
			}
			else {
				
				sb.append(puluhan[((int)angka / 10) - 1]);
				long tmp = angka % 10;
				
				if(tmp > 0){
					sb.append(" ");
					sb.append(satuan[((int)angka % 10)]);
				}
			}
		}
		
		return sb.toString(); 	
	}
}
