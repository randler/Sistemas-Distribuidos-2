package Atividade;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SalvarArq implements Runnable {
	OutputStream out;
	InputStream stream;
	
	public SalvarArq(OutputStream os, InputStream is) {
		this.out=os;
		this.stream=is;
	}

	@Override
	public void run() {

		byte[] bytes = new byte[16*1024];

        int count;
        try {
			while ((count = stream.read(bytes)) > 0) {
			    out.write(bytes, 0, count);
			}
	        out.close();
	        stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
