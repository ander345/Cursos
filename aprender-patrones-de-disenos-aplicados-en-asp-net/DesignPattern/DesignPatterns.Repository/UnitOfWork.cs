using DesignPatterns.Models.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Repository
{
    public class UnitOfWork : IUnitOfWork
    {
        private DesignPatternsContext _context;
        private IRepository<Beer> _beers;
        private IRepository<Brand> _brands;
        public IRepository<Beer> Beers
        {
            get
            {
                return _beers == null ?
                    _beers = new Repository<Beer>(_context) :
                    _beers;
            }
        }
        public IRepository<Brand> Brands
        {
            get
            {
                return _brands == null ?
                    _brands = new Repository<Brand>(_context) :
                    _brands;
            }
        }

        public UnitOfWork(DesignPatternsContext context)
        {
            this._context = context;
        }

        public void Save()
        {
            _context.SaveChanges();
        }
    }
}
