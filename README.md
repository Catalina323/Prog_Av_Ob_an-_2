##Aplicatie florarie
Pentru modelarea scenariului am folosit clasele: 
 -Buchet si Aranjament acestea reprezentand produsele ce pot fi vandute
 -Comtabilitate si Depozit pentru a putea gestiona profitul si stocul actual
 -Comanda Client si Angajat pentru a construi scenariul real
 -Data si ComparatorAngajatiData pentru a pastra o evidenta si a sorta angajatii
De asemenea am folosit si interfetele PreturiCumparare si PreturiVanzare si clasa Dimensiuni
Functionalitatile au fost definite in clasa Serviciu care contine urmatoarele metode:
 -afiseaza_angajati()
 -sorteaza_angajati_dupa_salariu()
 -sorteaza_angajati_dupa_data_angajare()
 -setAngajatulZilei()
 -calculeaza_bilant()
 -afiseaza_raport_stoc()
 -afiseaza_stoc()
 -cumpara_stoc(int nr)
 -istoric_comenzi(Client client)
 -comanda_buchete(Client client, Buchet ... buchet)
 -comanda_aranjamante(Client client, Aranjament ... aranjament)
 -calculeaza_pret_buchet(Buchet buchet)
 -calculeaza_pret_aranjament(Aranjament aranjament)
 -bilant_per_buchet(Buchet buchet)
 -bilant_per_aranjament(Aranjament aranjament)
 
