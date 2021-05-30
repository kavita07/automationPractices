export {}
let name: string = 'kavita';
let n: number = 10;
let isBigginer: boolean = true;
let sentence: string = `I am ${name}
I am bigginer`;
console.log(sentence);

let list1: number[] = [1,2,3];
let list2: Array<number> = [1,2,3];
let list3: [string, number] = ['kavita', 5];

enum color {Reg, Green, Yellow};

let c: color = color.Green;

console.log('color:'+c);

let anyType:any = 10;
anyType = true;
anyType = 'chavan';

console.log('anyType latest value:' + anyType);

let a;
a = 10;
a = 20;
