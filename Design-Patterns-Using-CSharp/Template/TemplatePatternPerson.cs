using System;

abstract class AbstractWorker
{
    // The template method
    public void DailyRoutine()
    {
        WakeUp();
        EatBreakfast();
        GoToWork();
        Work();
        ComeBackHome();
        EatDinner();
        Sleep();
    }

    protected void WakeUp()
    {
        Console.WriteLine("Wake Up");
    }

    protected void EatBreakfast()
    {
        Console.WriteLine("Eat Breakfast");
    }

    protected void GoToWork()
    {
        Console.WriteLine("Go to work");
    }

    protected abstract void Work();

    protected void ComeBackHome()
    {
        Console.WriteLine("Come back Home");
    }

    protected void EatDinner()
    {
        Console.WriteLine("Eat dinner");
    }

    protected void Sleep()
    {
        Console.WriteLine("Sleep");
    }
}

class Doctor : AbstractWorker
{
    protected override void Work()
    {
        Console.WriteLine("...Treat Patients...");
    }
}

class FireFighter : AbstractWorker
{
    protected override void Work()
    {
        Console.WriteLine("...Fight Fire...");
    }
}

class SuperHero : AbstractWorker
{
    protected override void Work()
    {
        Console.WriteLine("...Save the world!...");
    }
}

// Client code
class TemplatePatternPerson
{
    public static void Main(string[] args)
    {
        Doctor doctor = new Doctor();
        doctor.DailyRoutine();
        Console.WriteLine();

        FireFighter fireFighter = new FireFighter();
        fireFighter.DailyRoutine();
        Console.WriteLine();

        SuperHero superHero = new SuperHero();
        superHero.DailyRoutine();
    }
}
