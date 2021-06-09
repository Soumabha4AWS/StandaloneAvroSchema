package com.avro.demo.reflection.serializer;

 
    import java.util.Map;
    import org.apache.avro.generic.GenericRecord;
    import org.apache.avro.io.DatumReader;
    import org.apache.avro.io.Decoder;
    import org.apache.avro.io.DecoderFactory;
    import org.apache.avro.specific.SpecificDatumReader;
    import org.apache.avro.specific.SpecificRecordBase;
    import org.apache.kafka.common.serialization.Deserializer;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

import com.example.Customer;

public class AvroDeserializer1<T extends SpecificRecordBase> implements Deserializer {
	
	

	  

	@Override
	  public void configure(Map configs, boolean isKey) {
	    // do nothing
	  }

	  @Override
	  public T deserialize(String topic, byte[] bytes) {
	    T returnObject = null;
	    System.out.println("inside deserialize method");
	    try {

	      if (bytes != null) {
	        DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(new Customer().getSchema());
	        Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
	        returnObject = (T) datumReader.read(null, decoder);
	        System.out.println("deserialized data='{}'" + returnObject.toString());
	      }
	    } catch (Exception e) {
	    	System.out.println("Unable to Deserialize bytes[] " + e);
	    }

	    return returnObject;
	  }

	  @Override
	  public void close() {
	    // do nothing
	  }
	}