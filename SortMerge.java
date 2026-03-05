void intercalar(int primero, int mitad, int ultimo)
	int i, j, k, b[]
	b = new int[V[0] + 1]
	if (primero > mitad or mitad + 1 > ultimo) then return
	for (k = primero; k <= ultimo; k++) do
		b[k] = V[k]
	end(for
	i = primero
	j = mitad + 1
	k = primero – 1
	while ((i <= mitad) and (j <= ultimo)) do
		k = k + 1
		if (b[i] <= b[j]) then
			V[k] = b[i]
			i = i + 1
			else
			V[k] = b[j]
			j = j + 1
		end(if)
	end(while)
	while (i <= mitad) do
		k = k + 1
		V[k] = b[i]
		i = i + 1
	end(while)
	while (j <= ultimo) do
		k = k + 1
		V[k] = b[j]
		j = j + 1
	end(while)
fin(intercalar)
