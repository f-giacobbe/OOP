def cesare_transform(s, shift):
	res = ""
	for c in s:
		if c.isalpha():

			if c.isupper():
				base = ord("A")
			else:
				base = ord("a")

			res += chr((ord(c) - base + shift + 26) % 26 + base)

		else:
			#i caratteri non alfabetici rimangono invariati
			res += c

	return res




#Uso: java CodificaCesare <-e|-d> <file_input> <file_output> <shift>
def main(mode, input_file_path, output_file_path, shift):
	if mode == "-e":
		print("Modalità cifratura")
	elif mode == "-d":
		print("Modalità decifratura")
		shift = -shift
	else:
		print("Errore. Usa -e per cifrare e -d per decifrare")


	input_file = None
	output_file = None
	try:
		input_file = open(input_file_path, "r")
		output_file = open(output_file_path, "w")

		for s in input_file:
			processed_content = cesare_transform(s, shift)
			output_file.write(processed_content)

		print(f"Operazione completata! File salvato in {output_file_path}")

	except IOError:
		print("Errore durante la lettura/scrittura del file")
	finally:
		if input_file is not None:
			input_file.close()
		if output_file is not None:
			output_file.close()


main("-e", "C:\\Users\\franc\\Desktop\\OOP\\Python\\Esercitazione9\\testo.txt", "C:\\Users\\franc\\Desktop\\OOP\\Python\\Esercitazione9\\testo_criptato.txt", 3)
#main("-d", "C:\\Users\\franc\\Desktop\\OOP\\Python\\Esercitazione9\\testo_criptato.txt", "C:\\Users\\franc\\Desktop\\OOP\\Python\\Esercitazione9\\testo_criptato.txt", 3)
