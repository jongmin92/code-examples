## for loop - 1
for i in {1..10};
do
    date;
done

## for loop - 2
for i in {1..10};
do
    echo ${i};
done

## for loop - 3
for ((n=0; n<10; n++))
do
    echo ${n};
done

## while loop
END=5
x=$END
while [ $x -gt 0 ];
do
    date
    x=$(($x-1))
done
