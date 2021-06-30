cd "$(dirname "$0")"
cd C

for filename in *.c; do
    short_name="${filename%.*}"
    $(cc $filename -o $short_name.o)
done

echo "External dependencies initialized"
