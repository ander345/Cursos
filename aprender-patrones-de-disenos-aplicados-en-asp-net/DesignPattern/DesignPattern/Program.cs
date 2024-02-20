using DesignPattern.Models;
using DesignPattern.RepositoryPattern;
using DesignPattern.StrategyPattern;
using DesignPattern.UnitOfWorkPattern;
using System;
using System.Linq;

namespace DesignPattern
{
    class Program
    {
        static void Main(string[] args)
        {
            var context = new Context(new CarStrategy());
            context.Run();
            context.Strategy = new MotoStrategy();
            context.Run();
            context.Strategy = new BicycleStrategy();
            context.Run();
        }
    }
}
