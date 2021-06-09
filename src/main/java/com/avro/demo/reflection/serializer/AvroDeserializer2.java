package com.avro.demo.reflection.serializer;

import java.util.Arrays;
import java.util.Map;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import com.example.Customer;

public class AvroDeserializer2 implements Deserializer<GenericRecord> {

	@Override
	public void close() {

	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public GenericRecord deserialize(String topic, byte[] data) {
		System.out.println("inside deserialize");
		try {
			GenericRecord result = null;

			if (data != null) {
				DatumReader<Customer> reader = new SpecificDatumReader<>(new Customer().getSchema());

				Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
				result = (GenericRecord) reader.read(null, decoder);
			}
			return result;
		} catch (Exception ex) {
			throw new SerializationException(
					"Can't deserialize data '" + Arrays.toString(data) + "' from topic '" + topic + "'", ex);
		}
	}
}
