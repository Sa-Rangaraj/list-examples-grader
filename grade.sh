CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission 2> /dev/null


if [[ -f student-submission/ListExamples.java ]]
then
    cp student-submission/ListExamples.java grading-area/
    cp TestListExamples.java grading-area/
    cp -r lib grading-area/
else
    echo "File not found: ListExamples.java"
    exit 1
fi


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

cd grading-area

javac -cp $CPATH *.java  



if [[ $? -ne 0 ]]
then
  echo "Program failed to compile, compiler error shown above"
  exit 1
fi


java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > junit-output.txt


lastline=$(cat junit-output.txt | tail -n 2 | head -n 1)


if [[ $lastline = *OK* ]]
then
    totalTests=$(echo $lastline | awk -F'[ (]' '{print $3}')
    echo "Your score is: $totalTests/$totalTests"
else
    totalTests=$(echo $lastline | awk -F'[ ,]' '{print $3}')
    failures=$(echo $lastline | awk -F'[ ,]' '{print $6}')
    successes=$((totalTests - failures))
    echo "Your score is: $successes/$totalTests"
fi
